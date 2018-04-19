# Drools 规则引擎示例

文档地址：

- [Drools 7.7.0.Final](https://docs.jboss.org/drools/release/7.7.0.Final/drools-docs/html_single/index.html)
- http://mvel.documentnode.com/


## 1. drools-simple 项目

最简单的 drools 示例，可以用于练习规则语法等。

## 2. drools-xls 项目

使用决策表的例子，通过 Excel(xls) 批量创建规则。

## 3. drools-maven 项目

基于 Maven 仓库发布更新规则的项目，分为下面三个子项目。

### 3.1 drools-rules 项目

包含了规则内容（不包含任何 Java 代码），可以动态发布。

配合下面的 `PersonAutoUpdateClient` 测试时，可以通过修改规则提交到本地查看效果。

### 3.2 drools-fact 项目

规则和客户端使用的 fact 对象。

### 3.3 drools-client 项目

客户端示例，包含两个简单例子。

- `PersonClient` 示例仅仅使用了 `ReleaseId` 方式自动获取规则。

- `PersonAutoUpdateClient` 示例增加了 [`KieScanner`](https://docs.jboss.org/drools/release/7.7.0.Final/drools-docs/html_single/index.html#_kiescanner_2) 动态监测规则更新。

> `KieSession` 需要在更新后重新获取，旧的 Session 仍然使用旧的规则，重新获取后可以使用新的规则。
