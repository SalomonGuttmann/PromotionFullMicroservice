package com.appscampaign.ws.promotions.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;


@Service
public class PromotionServiceImpl implements PromotionService {

	private final KafkaTemplate<String, String> kafkaTemplate;
	private final ObjectMapper objectMapper;
	private final Logger LOGGER  = LoggerFactory.getLogger(this.getClass());

    public PromotionServiceImpl(KafkaTemplate<String, String> kafkaTemplate, ObjectMapper objectMapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }

    @Override
	public void publishPromotion(String json) {

		// TODO: Persist Promotion Details into database table before publishing an Event

		LOGGER.info("Before publishing a PromotionCreatedEvent");

		try {
			JsonNode root = objectMapper.readTree(json);
			JsonNode promo = root.path("zpmsPromoFull");

			if (promo.isMissingNode()) {
				throw new IllegalArgumentException("zpmsPromoFull missing");
			}

			int offerId = promo.path("offerId").asInt();
			String key = String.valueOf(offerId);

			SendResult<String, String> result = kafkaTemplate.send("PromotionFull", key, json).get();

			LOGGER.info("Partition: " + result.getRecordMetadata().partition());
			LOGGER.info("Topic: " + result.getRecordMetadata().topic());
			LOGGER.info("Offset: " + result.getRecordMetadata().offset());

		} catch (Exception e) {
			throw new RuntimeException("Invalid PromotionFull event", e);
		}
	}

}
