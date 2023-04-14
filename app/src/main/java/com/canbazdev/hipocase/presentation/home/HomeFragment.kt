package com.canbazdev.hipocase.presentation.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.core.widget.doOnTextChanged
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.canbazdev.hipocase.R
import com.canbazdev.hipocase.adapter.DevelopersAdapter
import com.canbazdev.hipocase.adapter.DevelopersAdapterItemDecoration
import com.canbazdev.hipocase.data.model.hipo.Hipo
import com.canbazdev.hipocase.data.model.hipo.Member
import com.canbazdev.hipocase.databinding.FragmentHomeBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.textfield.TextInputEditText
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val viewModel: HomeViewModel by viewModels()
    private lateinit var developersAdapter: DevelopersAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_home, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getDevelopers()

        developersAdapter = DevelopersAdapter()

        binding.rvDevelopers.let {
            it.adapter = developersAdapter
            it.addItemDecoration(DevelopersAdapterItemDecoration())
        }


        observe()


        binding.btnAddNewMember.setOnClickListener {
            showAddNewMemberDialog()
        }

        binding.etSearch.doOnTextChanged { text, _, _, _ ->
            val filterList = viewModel.developers.value.filter {
                it.name.lowercase().startsWith(text.toString())
            }
            developersAdapter.setDevelopersList(filterList)


        }

    }

    private fun observe() {
        lifecycleScope.launchWhenCreated {
            viewModel.developers.collect {
                developersAdapter.setDevelopersList(it)
            }

        }

    }

    private fun showAddNewMemberDialog() {
        val bottomSheetDialog = BottomSheetDialog(requireContext())
        bottomSheetDialog.setContentView(R.layout.add_new_member_bottom_sheet)
        val name = bottomSheetDialog.findViewById<TextInputEditText>(R.id.etName)
        val position =
            bottomSheetDialog.findViewById<TextInputEditText>(R.id.etPosition)
        val saveButton =
            bottomSheetDialog.findViewById<Button>(R.id.btnSave)

        saveButton?.setOnClickListener {
            viewModel.addNewMemberToDevelopers(
                Member(
                    hipo = Hipo(position?.text.toString()),
                    name = name?.text.toString()
                )
            )
            observe()
            bottomSheetDialog.dismiss()
        }

        bottomSheetDialog.show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}