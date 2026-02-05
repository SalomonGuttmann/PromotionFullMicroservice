package com.appscampaign.ws.promotions.rest;

import com.appscampaign.ws.promotions.service.PromotionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/promotions") //http://localhost:<port>/promotions
public class PromotionController {

	private final PromotionService promotionService;
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    public PromotionController(PromotionService promotionService) {
        this.promotionService = promotionService;
    }


    @PostMapping
	public ResponseEntity<ErrorMessage> publishPromotion(@RequestBody CreatePromotionRestModel request) {

		try {
			promotionService.publishPromotion(request.getPromotionFullJson());
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ErrorMessage(new Date(), e.getMessage(),"/promotions"));
		}
		
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
}
