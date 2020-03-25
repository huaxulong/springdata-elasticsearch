package com.huaxu.elasticsearch.bean;

import org.elasticsearch.index.VersionType;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "bank" , type = "doc" , shards = 1, replicas = 0,
        createIndex = false,useServerConfiguration = true,versionType = VersionType.EXTERNAL)
public class Bank {

    @Id
    private long account_number;

    @Field(type = FieldType.Double)
    private  double balance;

    @Field(type = FieldType.Text)
    private  String firstname;

    @Field(type = FieldType.Text)
    private  String lastname;

    @Field(type = FieldType.Integer)
    private  int age;

    @Field(type = FieldType.Text)
    private  String gender;

    @Field(type = FieldType.Text)
    private  String address;

    @Field(type = FieldType.Text)
    private  String employer;

    @Field(type = FieldType.Text)
    private  String email;

    @Field(type = FieldType.Text)
    private  String city;


    @Field(type = FieldType.Keyword)
    private   String state;



}
