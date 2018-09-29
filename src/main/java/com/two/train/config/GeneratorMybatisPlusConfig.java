package com.two.train.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chsm
 */
public class GeneratorMybatisPlusConfig {

    public static void main(String[] args) {
        // 自定义需要填充的字段
        List<TableFill> tableFillList = new ArrayList<>();
        tableFillList.add(new TableFill("gmt_create", FieldFill.INSERT));
        tableFillList.add(new TableFill("gmt_modified", FieldFill.INSERT_UPDATE));
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator()
                .setGlobalConfig(
                        // 全局配置
                        new GlobalConfig()
                                //输出目录
                                .setOutputDir("C:\\Users\\chsm\\IdeaProjects\\train\\src\\main\\java")
                                // 是否覆盖文件
                                .setFileOverride(false)
                                // 开启 activeRecord 模式
                                .setActiveRecord(false)
                                // XML 二级缓存
                                .setEnableCache(false)
                                // XML ResultMap
                                .setBaseResultMap(true)
                                // XML columList
                                .setBaseColumnList(true)
                                .setSwagger2(true)
                                .setOpen(false)
                                .setAuthor("chsm")).setDataSource(
                        // 数据源配置
                        new DataSourceConfig()
                                // 数据库类型
                                .setDbType(DbType.MYSQL)
                                .setDriverName("com.mysql.jdbc.Driver")
                                .setUsername("three")
                                .setPassword("team")
                                .setUrl("jdbc:mysql:///two_train?characterEncoding=utf8"))
                .setStrategy(
                        // 策略配置
                        new StrategyConfig()
                                // 表名生成策略
                                .setNaming(NamingStrategy.underline_to_camel)
                                .setTableFillList(tableFillList)
                                .setEntityBooleanColumnRemoveIsPrefix(true)
                                .setInclude("manager")
                                .setEntityLombokModel(true)
                                .setRestControllerStyle(true))
                .setPackageInfo(
                        // 包配置
                        new PackageConfig()
                                .setParent("com.two.train"));
        mpg.execute();
    }

}
