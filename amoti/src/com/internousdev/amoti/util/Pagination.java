package com.internousdev.amoti.util;

import java.util.ArrayList;
import java.util.List;

import com.internousdev.amoti.dto.PaginationDTO;
import com.internousdev.amoti.dto.ProductInfoDTO;

public class Pagination {

	public PaginationDTO initialize(List<ProductInfoDTO> list, int pageSize) {
		PaginationDTO paginationDTO = new PaginationDTO();
		if(list.size() % pageSize > 0){
			paginationDTO.setTotalPageSize((int)(Math.ceil(list.size() / pageSize)) + 1);
		}else{
			paginationDTO.setTotalPageSize((int)(Math.ceil(list.size() / pageSize)));
		}
		paginationDTO.setCurrentPageNo(1);
		paginationDTO.setTotalRecordSize(list.size());
		paginationDTO.setStartRecordNo(pageSize * (paginationDTO.getCurrentPageNo() -1) + 1);
		paginationDTO.setEndRecordNo(paginationDTO.getStartRecordNo() + pageSize - 1);

		List<Integer> pageNumberList = new ArrayList<Integer>();
		for(int pageNumber = 1; pageNumber <= paginationDTO.getTotalPageSize(); pageNumber++) {
			pageNumberList.add(pageNumber);
		}

		paginationDTO.setPageNumberList(pageNumberList);

		List<ProductInfoDTO> currentProductInfoPage = new ArrayList<ProductInfoDTO>();
		int startI = paginationDTO.getStartRecordNo() - 1;
		int endI2 = Math.min(paginationDTO.getEndRecordNo(), paginationDTO.getTotalRecordSize());
		for (int i = startI; i < endI2; i++) {
			ProductInfoDTO productInfoDto = list.get(i);
			currentProductInfoPage.add(productInfoDto);
		}

		paginationDTO.setCurrentProductInfoPage(currentProductInfoPage);

		if((paginationDTO.getStartRecordNo() - 1) <= 0) {
			paginationDTO.setPreviousPage(false);
		}else {
			paginationDTO.setPreviousPage(true);
			paginationDTO.setPreviousPageNo(paginationDTO.getCurrentPageNo() - 1);
		}

		if(paginationDTO.getEndRecordNo() + pageSize > paginationDTO.getTotalRecordSize()) {
			paginationDTO.setNextPage(false);
		}else {
			paginationDTO.setNextPage(true);
			paginationDTO.setNextPageNo(paginationDTO.getCurrentPageNo() + 1);
		}
		return paginationDTO;
	}


	public PaginationDTO getPage(List<ProductInfoDTO> list, int pageSize, String pageNo) {

		PaginationDTO paginationDTO = new PaginationDTO();
		if(list.size() % pageSize > 0){
			paginationDTO.setTotalPageSize((int)(Math.ceil(list.size() / pageSize)) + 1);
		}else{
			paginationDTO.setTotalPageSize((int)(Math.ceil(list.size() / pageSize)));
		}
		paginationDTO.setCurrentPageNo(Integer.parseInt(pageNo));
		paginationDTO.setTotalRecordSize(list.size());
		paginationDTO.setStartRecordNo(pageSize * (paginationDTO.getCurrentPageNo() -1) + 1);
		paginationDTO.setEndRecordNo(paginationDTO.getStartRecordNo() + (pageSize - 1));

		List<Integer> pageNumberList = new ArrayList<Integer>();
		for(int pageNumber = 1; pageNumber <= paginationDTO.getTotalPageSize(); pageNumber++) {
			pageNumberList.add(pageNumber);
		}

		paginationDTO.setPageNumberList(pageNumberList);

		List<ProductInfoDTO> currentProductInfoPage = new ArrayList<ProductInfoDTO>();
		int startI = paginationDTO.getStartRecordNo() - 1;
		int endI2 = Math.min(paginationDTO.getEndRecordNo(), paginationDTO.getTotalRecordSize());
		for (int i = startI; i < endI2; i++) {
			ProductInfoDTO productInfoDto = list.get(i);
			currentProductInfoPage.add(productInfoDto);
		}
		paginationDTO.setCurrentProductInfoPage(currentProductInfoPage);

		if((paginationDTO.getStartRecordNo() - 1) <= 0) {
			paginationDTO.setPreviousPage(false);
		}else {
			paginationDTO.setPreviousPage(true);
			paginationDTO.setPreviousPageNo(paginationDTO.getCurrentPageNo() - 1);
		}

		if(paginationDTO.getEndRecordNo() + pageSize > paginationDTO.getTotalRecordSize()) {
			paginationDTO.setNextPage(false);
		}else {
			paginationDTO.setNextPage(true);
			paginationDTO.setNextPageNo(paginationDTO.getCurrentPageNo() + 1);
		}

		return paginationDTO;

	}

}
