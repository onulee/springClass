package com.java.www.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class GalleryListDto {
	
	private String galContentId;
	private String galContentTypeId;
	private String galTitle;
	private String galWebImageUrl;
	private String galCreatedtime;
	private String galModifiedtime;
	private String galPhotographyMonth;
	private String galPhotographyLocation;
	private String galPhotographer;
	private String galSearchKeyword;

}
