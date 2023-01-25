/*
 * FILE : RestResponseEntityExceptionHandler.java
 *
 * COPYRIGHT:
 *
 * The computer systems, procedures, data bases and programs created and maintained by SS&C Health,
 * are proprietary in nature and as such are confidential. Any unauthorized use or disclosure of
 * such information may result in civil liabilities.
 *
 * Copyright (C) 2021- by SS&C Health. All Rights Reserved.
 *
 */
package com.domanirx.drxconditions.api.conditions.exceptions;

import com.rxtransaction.common.api.exceptions.RestResponseEntityExceptionHandlerBase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;

@Slf4j
@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestResponseEntityExceptionHandler extends RestResponseEntityExceptionHandlerBase {}
