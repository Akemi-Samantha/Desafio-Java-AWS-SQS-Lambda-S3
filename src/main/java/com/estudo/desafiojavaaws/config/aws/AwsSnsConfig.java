package com.estudo.desafiojavaaws.config.aws;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import com.amazonaws.services.sns.model.Topic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AwsSnsConfig {

    @Value("${aws.region}")
    private String region;
    @Value("${aws.accessKeyId}")
    private String accessKeyId;
    @Value("${aws.secretKey}")
    private String secretKey;
    @Value("${aws.sns.topic.catalog.arn}")
    private String catalogTopicArn;

    //Toda vez que eu tiver uma dependência do tipo Amazon SNS o Spring vai chamar esse método para criar a instancia dessa dependência
    @Bean
    public AmazonSNS amazonSNSBuilder() {
        BasicAWSCredentials awsCredentials = new BasicAWSCredentials(accessKeyId, secretKey);
        return AmazonSNSClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                .withRegion(region)
                .build();
    }

    @Bean("catalogEventsTopic")
    public Topic snsCatologTopicBuilder() {
        return new Topic().withTopicArn(catalogTopicArn);
    }
}
