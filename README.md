# Drools 规则引擎示例

文档地址：

- [Drools 7.7.0.Final](https://docs.jboss.org/drools/release/7.7.0.Final/drools-docs/html_single/index.html)
- http://mvel.documentnode.com/


## drools-simple 项目

最简单的 drools 示例，可以用于练习规则语法等

## drools-maven 项目

基于 Maven 仓库发布更新规则的项目。

- drools-rules 项目包含了规则内容（不包含任何 Java 代码），可以动态发布。
- drools-fact 规则和客户端使用的 fact 对象。
- drools-client 客户端示例。

>该项目仅用于简单的学习和演示，没有在生产环境使用过。

### drools-client

`PersonClient` 示例仅仅使用了 `ReleaseId` 方式自动获取规则。

`PersonAutoUpdateClient` 示例增加了 [`KieScanner`](https://docs.jboss.org/drools/release/7.7.0.Final/drools-docs/html_single/index.html#_kiescanner_2) 动态监测规则更新。

> `KieSession` 需要在更新后重新获取。
> `KieSession` 可以很高效的获取，按照文档建议，`KieContainer` 可以作为单例反复使用。`KieSession` 可以反复获取使用。

## 后续会根据对官方文档的学习增加其他示例