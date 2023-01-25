/*
 * FILE : JpaConfig.java
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

import com.rxtransaction.common.api.config.JpaConfigBase;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.domanirx.drxconditions.api.conditions.controller")
@EnableJpaAuditing(
    auditorAwareRef = "auditorAware",
    dateTimeProviderRef = "auditingDateTimeProvider")
@ConfigurationProperties
public class JpaConfig extends JpaConfigBase {

  public JpaConfig() {
    packagesToScan.add("com.domanirx.drxconditions.service.drxconditions.domains");
    setNamingStrategy(
        "com.domanirx.drxconditions.api.drxconditions.config.CustomPhysicalNamingStrategy");
  }

  @Bean
  public AuditorAware<String> auditorAware() {
    return new AuditorAwareImpl();
  }
}
