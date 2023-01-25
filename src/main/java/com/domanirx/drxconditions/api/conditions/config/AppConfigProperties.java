/*
 * FILE : AppConfigProperties.java
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
package com.domanirx.drxconditions.api.conditions.config;

import com.rxtransaction.common.api.config.AppConfigPropertiesBase;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties()
@ConfigurationProperties()
@Getter
@Setter
public class AppConfigProperties extends AppConfigPropertiesBase {}
