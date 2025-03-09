package com.mdemiguels.spring_cloud_client.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "com.mdemiguels.spring_cloud_client.proxy")
public class ProjectConfig {
}
