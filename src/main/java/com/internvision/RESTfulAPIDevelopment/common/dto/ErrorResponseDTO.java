package com.internvision.RESTfulAPIDevelopment.common.dto;

import java.util.List;


public record ErrorResponseDTO(int status, String message, List<FieldMessage> fieldErrors) {



}
