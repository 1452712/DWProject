﻿# Data Warehouse

### Submission

1.  ETL脚本

2.  E-R图

3.  物理存储模型（Schema）

4.  数据仓库导出文件（请按照每张表分别导出csv格式文件并压缩。文件名同表名）

5.  分布式文件系统导出文件，schema定义文件

6.  查询和统计程序 （**包括爬虫脚本和数据清洗的代码**）

7.  每组准备一个答辩ppt，说明整体思考过程和解决方案。

8.  组员姓名学号&百分比

### Solution

- 考虑到本项目为静态数据, 以提高检索&获取数据速度为重点:

    1. 针对各搜索高频度的属性建立维度表, 针对只需要统计总数的需求, 存储Count(即可通过直接查询一次dimension表得到结果);

    2. 为避免做字符串解析或join, 建立list分表(以Category为例, 总共约200,000条数据, 30个Category, 则平均每个分类下有约7,000部电影, 需要解析的字符串太长);

    3. 为方便直接读取每一部电影的数据, 同时将所有属性存储于movie表中, 并将属性统一存储为字符串而非子表.

- 由于数据量过大, 对数据进行拆分:

    1. review表进行了横向拆表;

    2. 并将Text内容存在非关系型的文件系统中, 在数据库中存储其路径的url.

- 根据未来可能添加数据的需求, 维护雪花模型:

    1. 即以movie表为fact表, movie表前半部分为属性值, 后半部分为维度表id(primary不使用拼接dimension id);

    2. 通过建立movie\_review\_bridge表构建review同movie的关联, 保留review中的ProductId;

    3. 预留检索review和user的接口.

### Optimization

- Name -> Hash

### Collaboration & Percentage

- 爬虫&数据解析: 张尹嘉(1452716, 25%)
- 数据仓库: 王冠淞(1452693, 25%)
- 前端: 项安颖(1452719, 25%)
- 后端: 王家慧(1452712, 25%)

### Schedule

a) 建模&建项目
>12.04 24:00

b) 抽数据&建数据仓库(Hadoop架构)
>12.08 24:00

c) 后端&前端实现
>12.13 24:00

d) 整理文件
>12.14 24:00

e) 填充数据
>12.17 24:00

f) 准备答辩
>01.?
