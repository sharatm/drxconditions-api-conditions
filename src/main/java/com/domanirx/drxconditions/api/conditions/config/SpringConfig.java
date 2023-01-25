/*
 * FILE : SpringConfig.java
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

import com.rxtransaction.common.api.config.SpringConfigBase;
import com.rxtransaction.common.api.config.TomcatEmbedServerCommonApiConfigration;
import com.rxtransaction.datasource.DataSourceConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@Import({DataSourceConfiguration.class, TomcatEmbedServerCommonApiConfigration.class})
public class SpringConfig extends SpringConfigBase {

  //   Uncomment this code if you do need the MasterSetIdFilter
  //    @Bean
  //    public FilterRegistrationBean<MasterSetIdFilter> registerFilter() {
  //      FilterRegistrationBean<MasterSetIdFilter> registrationBean = new
  // FilterRegistrationBean<>();
  //
  //      registrationBean.setFilter(new MasterSetIdFilter());
  // registrationBean.addUrlPatterns("/*");
  //
  //      return registrationBean;
  //    }

}
