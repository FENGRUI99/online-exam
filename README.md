# online-exam

### 1. 介绍

学生在线考试系统：基于Springboot，druid，Mybatis，Mysql，pagehelper

- 支持学生，教师两种角色
- 学生
  - 参加考试
  - 查看历史考试
- 教师
  - 添加，删除学生
  - 添加，删除试题
  - 添加，删除考试
  - 生成试卷

### 2. 安装与使用

- 1.下载代码

  ```shell
  git clone https://github.com/FENGRUI99/online-exam.git
  cd online-exam
```

- 2.初始化数据库

  新建exam数据库，密码和`online-exam/src/main/resources/application.yml`的`password: xxxxxx`保持一致，然后导入`oneline-exam/exam.sql`

- 3.启动

  打开`online-exam`这个Maven项目，可以在IDE里启动或者执行`mvn install`生成jar包启动
