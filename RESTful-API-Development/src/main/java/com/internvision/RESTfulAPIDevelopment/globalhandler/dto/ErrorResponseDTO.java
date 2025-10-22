package com.internvision.RESTfulAPIDevelopment.globalhandler.dto;

import java.util.List;


public record ErrorResponseDTO(int status, String message, List<FieldMessage> fieldErrors) {



}
