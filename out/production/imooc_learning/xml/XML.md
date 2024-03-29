# XML

> 行百里者半九十

[TOC]

## XML书写规则

- 合法的标签名
- 适当的注释与缩进
- 合理使用属性
- 特殊字符和CDATA标签
- 有序的子元素

### 合法的标签名

- 标签名要有意义
- 建议使用英文，小写字母，单词之间使用“-”分割
- 建议多级标签之间不要存在重名的情况

### 适当的注释与缩进

- 适当的注释与缩进可以让XML文档更容易理解

### 合理使用属性

- 标签属性用于描述标签不可或缺的信息

### 处理特殊字符

- 标签内容中出现特殊字符，会破坏文档结构

  - 使用实体引用

    特殊的符号有对应的引用可以直接替换

  - 使用CDATA标签

    用<![CDATA[内容]]>包裹

### 有序的子元素

- 在XML多层嵌套的子元素中，标签前后顺序应保持一致

## XML语义约束

- XML文档结构正确，但是可能是不有效的

  例如，员工文档XML中绝对不允许出现植物品种标签。XML予以越苏就是用于规定XML文档中允许出现哪些元素

- XML允许有两种定义方式：**DTD**与**XML Schema**

  - DTD

    文档类型定义，这是一种简单易用的语义约束方式。DTD文件扩展名为.dtd。利用<!ELEMENT>标签，可以定义文档中出现的节点数量。

    - 节点下出现某个子节点的数量
    - 必须包含的节点，且按顺序出现
    - 定义某一标签体只能是文本元素
    - 使用<!DOCTYPE>标签来引用DTD文件

  - XML Schema

    比DTD更加复杂，提供了更多功能，也提供了数据类型，格式限定，数据范围等特性。

    

    