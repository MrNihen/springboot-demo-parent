<html>
<head>
    <meta charset="utf-8">
    <title>Freemarker入门小DEMO </title>
</head>
<body>
<#--&lt;#&ndash;我只是一个注释，我不会有任何输出  &ndash;&gt;-->
<#--${name},你好。${message}-->
<#--&lt;#&ndash;页面包含&ndash;&gt;-->
<#--<#include "header.ftl">-->
<#--<hr>-->

<#--&lt;#&ndash;1.定义基本变量&ndash;&gt;-->
<#--<#assign linkman="小吴">-->
<#--你的名字叫: ${linkman} <br>-->
<#--<#assign aa=true>-->
<#--&lt;#&ndash;2.定义对象类型的变量&ndash;&gt;-->
<#--<#assign stud={"sid":1001,"sname":"张三","sex":"男","age":20,"addr":"上海"}>-->
<#--学号：${stud.sid?c} <br>-->
<#--姓名：${stud.sname} <br>-->
<#--性别：${stud.sex} <br>-->
<#--年龄：${stud.age} <br>-->
<#--住址：${stud.addr} <br>-->

<#--&lt;#&ndash;3.条件判断&ndash;&gt;-->
<#--<#if aa=true>-->
<#--    存在变量aa-->
<#--    <#else>-->
<#--    不存在变量aa-->
<#--</#if>-->

<#--<hr>-->
<#--&lt;#&ndash;4.遍历数据&ndash;&gt;-->
<#--<#list list as fruit>-->
<#--    <li>${fruit.id} | ${fruit.fname} | ${fruit.price} | ${fruit.num}</li>-->
<#--</#list>-->
<#--共${list?size}条记录！ <br>-->

<#--&lt;#&ndash;5.将json字符串转换为json对象&ndash;&gt;-->
<#--<#assign text="{'bank':'工商银行','account':'10101920201920212'}" />-->
<#--<#assign bk = text?eval>-->
<#--账户：${bk.account} <br>-->
<#--名称：${bk.bank} <br>-->

<#--6.日期格式化处理-->
当前日期：${today?date} <br>
当前时间：${today?time} <br>
当前日期时间：${today?datetime} <br>
自定义日期：${today?string("yyyy年MM月dd日 hh:mm:ss")} <br>

<#--&lt;#&ndash;7.数字格式处理&ndash;&gt;-->
<#--${point?c} <br>-->

<#--&lt;#&ndash;8.处理null值的情况&ndash;&gt;-->
<#--<#if hello?? >-->
<#--    大家早上好！-->
<#--    <#else >-->
<#--    下午好！-->
<#--</#if>-->

<#--&lt;#&ndash;9.为变量指定默认值&ndash;&gt;-->
<#--${hello!'hello'} <br>-->

</body>
</html>