package com.nanking.models.dto;

import com.nanking.models.domain.InDocument;

import java.util.List;

public class InDocumentDto {


    private List<InDocument> inDocumentList;

    public List<InDocument> getInDocumentList() {
        return inDocumentList;
    }

    public void setInDocumentList(List<InDocument> inDocumentList) {
        this.inDocumentList = inDocumentList;
    }
}
