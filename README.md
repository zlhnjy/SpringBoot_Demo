# SpringBoot_Demo

## demo_01
&emsp; Spring基础  
&emsp; 基于注解的配置 | JavaConfig配置 | AOP

## demo_02
&emsp; Spring常用配置  
&emsp; Bean的Scope | Spring El和资源调用 

## demo_08 
&emsp; @Autowired @Resource  
&emsp; Spring Data JPA  
&emsp;&emsp; Spring Data JPA对所有的默认方法都开启了事务支持，查询类事务默认启用readOnly=true  
&emsp;&emsp; 在默认的代理模式下，只有目标方法由外部调用，才能被 Spring 的事务拦截器拦截。在同一个类中的两个方法直接调用，是不会被 Spring 的事务拦截器拦截，就像上面的 save 方法直接调用了同一个类中的 method1方法，method1 方法不会被 Spring 的事务拦截器拦截。  
&emsp; @EnableCaching @Cachable

## demo_09
&emsp; 批处理Spring Batch

