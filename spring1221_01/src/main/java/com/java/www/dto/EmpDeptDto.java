package com.java.www.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmpDeptDto {

	private EmpDto empDto;
	private DeptDto deptDto;
}
