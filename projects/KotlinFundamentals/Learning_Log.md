# Android 学习日志

记录每日核心理解、避坑总结、英语词汇

#### GitHub代码提交并托管
git add .
git commit -m "你的提交信息"
git push origin main


## 12/23 状态提升 


### 核心收获
- 掌握无状态组件设计
- 实现逻辑/UI 分离
- - **无状态组件**：UI 只接收数据+回调，不持有状态
- **状态持有者**：父组件管理逻辑，确保单一数据源
- 多处复用（主屏 + 设置页）

### 英语术语
- stateless component: 无状态组件
- unidirectional data flow: 单向数据流
- manual verification: 手动验证
- hoisting: 状态提升


## 2025-12-20/21 作用域apply，run/高阶函数filter，map

# 作用域apply，run
1. apply：操作对象，返回对象本身 → 适合 “创建 + 初始化” 对象
2. run：操作对象，返回最后一行结果 → 适合 “操作对象后返回计算值”；

# 高阶函数filter，map
1. filter：集合的 “过滤器”，作用是只保留符合条件的元素，返回新列表
2. map：集合的 “转换器”，作用是把每个元素按规则转换成新值，返回新列表（长度和转换前一致）；
3. 链式调用：filter 后直接接 map，不用定义临时变量，代码更简洁
4. 区间判断 it in a..b：等价于 it >= a && it <= b，是 Kotlin 简化写法

### 英语词汇
- scope 作用域
- initialize 初始化
- configuration 配置
- mutable 可变的
- expression 表达式
- temporary 临时的
- filter 过滤
- map 转换/映射
- valid 有效的
- range 范围
- imperative 命令式
- declarative 声明式
- refactor 重构
* scope function 作用域函数


## 2025-12-19 扩展函数

# 扩展函数


### 英语词汇
- extension 扩展
- receiver 接收者
- intuitive 直观的 直觉的
- convenience 便利
- method 方法
- format 格式化
* extension function 扩转函数
* receive type 接收者类型
* intuitive syntax 直观语法
* unit conversion 单位转换
* convenience method 便利方法



## 2025-12-18 安全处理用户输入

# 空安全处理：
takeIf（过滤） + toDoubleOrNull（安全转换） + ?.（空安全调用） + ?:（兜底）
是处理用户输入的 “黄金组合”，避免崩溃；

# Compose 基础：
1. @Composable函数构建 UI；
2. Column(纵向) / Row(横向) / Box(层叠) 是基础布局；
3. Modifier设置样式；通过链式调用设置布局 / 组件的样式（比如padding内边距、size大小、clickable点击事件等）
4. 状态管理（remember+mutableStateOf）实现 UI 刷新；

# 企业级思路：用户输入的字符串永远不可信，必须做 “非空、非空白、类型转换” 三层校验，再处理业务逻辑。

# 完整运行逻辑（从代码到界面）
1. 当 APP 启动，执行setContent，加载主题和Surface； 
2. Surface中调用TemperatureInputDemo，渲染Column布局； 
3. Column中渲染Text组件，执行safeConvertCelsius("100")： 
4. 输入 "100" → 经过链式调用，返回 100.0； 
5. 字符串模板拼接成 “有效输入： 100.0”； 
6. 最终界面上会显示一行文字：有效输入： 100.0。


### 英语词汇
- safe convert input → 安全转换输入
- chain call → 链式调用
- default value → 默认值
- handle null →处理空值
- readable status → 可读状态
- separate → 分离


## 2025-12-17 主次构造函数
# 类的核心：
1. 主构造函数：类名后声明属性，简化代码；
2. init块：初始化 / 校验，require保证参数合法；
# 数据类：
1. data class：自动生成toString()/equals()/copy()，专门存数据；
2. 计算属性：get()动态计算，不存储；
3. 不可变性：用val+copy()，避免意外修改；
# 企业级设计：
1. 分离 “数据” 和 “逻辑”，代码更易维护；
2. 次构造函数仅用于兼容旧代码，优先用 “主构造 + 默认参数”。
PS：Kotlin 更推荐「主构造 + 默认参数」替代次构造
（比如class Sensor(val min: Double = 0.0, val max: Double = 100.0)），次构造主要用于兼容旧逻辑。 
3. range: Pair<Double, Double> = 定义一个名为 range 的属性，它的类型是 “存储两个 Double 类型元素的成对数据结构”
   Pair 是 Kotlin 标准库提供的通用数据结构，专门用来存储「两个关联的元素」（可以理解为 “键值对”“成对数据”）