package com.mx.mit.bnpl.notificacion.whatsapp.dto.response;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Result implements Serializable {
    @JsonProperty("list")
    private List list;

    @JsonProperty("event")
    private Event event;

    @JsonProperty("meta")
    private Meta meta;

    @JsonProperty("insights_topics")
    private List<Object> insightsTopics;

    @JsonProperty("insights_general_intent")
    private boolean insightsGeneralIntent;

    @JsonProperty("_id")
    private String id;

    @JsonProperty("author")
    private String author;

    @JsonProperty("event_type")
    private String eventType;

    @JsonProperty("text")
    private String text;

    @JsonProperty("is_hsm")
    private boolean isHSM;

    @JsonProperty("hsm_name")
    private String hsmName;

    @JsonProperty("conversation_id")
    private String conversationID;

    @JsonProperty("platform")
    private String platform;

    @JsonProperty("user_id")
    private String userID;

    @JsonProperty("account_id")
    private long accountID;

    @JsonProperty("postback_response")
    private boolean postbackResponse;

    @JsonProperty("date")
    private OffsetDateTime date;
    @JsonProperty("buttons")
    private List<Object> buttons;

    @JsonProperty("gallery")
    private List<Object> gallery;

    @JsonProperty("quick_replies")
    private List<Object> quickReplies;

    @JsonProperty("trace")
    private List<Trace> trace;

    @JsonProperty("__v")
    private long v;

    @JsonProperty("external_id")
    private String externalID;

    @JsonProperty("status")
    private String status;

}
