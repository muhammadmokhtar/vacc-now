package com.digitalfactory.vaccnow.bussiness.service;

import com.digitalfactory.vaccnow.bussiness.dto.BranchDTO;
import com.digitalfactory.vaccnow.data.entity.Branch;
import com.digitalfactory.vaccnow.data.repository.BranchRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class BranchService {

    private ModelMapper modelMapper;
    private BranchRepository branchRepository;

    @Autowired
    public BranchService(BranchRepository branchRepository,ModelMapper modelMapper) {
        this.branchRepository = branchRepository;
        this.modelMapper = modelMapper;
    }

    public List<String> getAllBranchesNames() {
        return branchRepository.getAllBranchesNames();
    }
    public List<BranchDTO> getAllBranches() {
        List<BranchDTO> branches = new ArrayList<>();
        Iterator<Branch> iterator = branchRepository.findAll().iterator();
       while (iterator.hasNext()) {
           branches.add(modelMapper.map(iterator.next(), BranchDTO.class));
       }
       return branches;
    }
}
