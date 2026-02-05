package com.appscampaign.ws.promotions.rest;

import jakarta.validation.constraints.NotBlank;

public class CreatePromotionRestModel {

	/**
	 * PromotionFull JSON gemäß Schema
	 */
	@NotBlank
	private String promotionFullJson;

	public String getPromotionFullJson() {
		return promotionFullJson;
	}

	public void setPromotionFullJson(String promotionFullJson) {
		this.promotionFullJson = promotionFullJson;
	}

}
