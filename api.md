#帮跑跑API文档
## 地址管理：
#### 添加地址：
###### URI：/address/addNew
###### 请求方法：POST
###### 参数：
###### Address address 地址
###### Integer uid 用户id
###### String username 用户名
#### 删除地址：
###### URI：/address/{aid}/delete
###### 请求方法：DELETE
###### 参数：
###### Integer aid 地址id
###### Integer uid 用户id
###### String username 用户名
###### 参数：
#### 更新地址：
###### URI：/address/{aid}/update
###### 请求方法：POST
###### 参数：
###### Integer aid 地址id
###### Integer uid 用户id
###### String username 用户名
###### Address address 修改后的地址
#### 获取全部地址：
###### URI：/address
###### 请求方法：GET
###### 参数：
###### Integer uid 用户名
#### 根据aid获取地址：
###### URI：null
###### 参数：
###### null

---

## 评价管理：
#### 添加评价：
###### URI：/appraise/create
###### 请求方法：POST
###### 参数：
###### Appraise appraise 评价
###### Integer oid 订单id
#### 删除评价：
###### URI：/appraise/{aid}/delete
###### 请求方法：DELETE
###### 参数：
###### Integer aid 评价id
#### 查询某个评价：
###### URI：/appraises/{aid}/get
###### 请求方法：GET
###### 参数：
###### Integer aid 评价id 
#### 查询某订单的所有评价：
###### URI：/appraises/{oid}
###### 请求方法：GET
###### 参数：
###### Integer oid 订单id

---

## 订单管理
#### 创建或修改订单：
###### URI：/order/edit
###### 请求方法：POST
###### 参数：
###### Order order 订单
#### 删除订单：
###### URI：/order/delete
###### 请求方法：DELETE
###### 参数：
###### Long id 订单id
#### 取消订单：
###### URI：/order/cancel
###### 请求方法：POST
###### 参数：
###### Long orderId 订单id
#### 修改状态为已接单：
###### URI：/order/accept
###### 请求方法：POST
###### 参数：
###### Long orderId 订单id
###### String accepterId 接单人id
#### 修改状态为送货中：
###### URI：/order/deliver
###### 请求方法：POST
###### 参数：
###### Long orderId 订单id
#### 修改状态为已接收：
###### URI：/order/receive
###### 请求方法：POST
###### 参数：
###### Long orderId 订单id
#### 根据id查询订单信息：
###### URI：/order/list/{id}
###### 请求方法：GET
###### 参数：
###### Long id 订单id
#### 分页查询全部未接单订单信息：
###### URI：/order/list_status0
###### 请求方法：GET
###### 参数：
###### int pageIndex 分页的页号
###### int pageSize 分页的size
#### 根据订单状态和id分页查询全部订单信息：
###### URI：/order/list_idstatus
###### 请求方法：GET
###### 参数：
###### String id 用户的openId
###### int status 订单状态
###### int pageIndex 分页的页号
###### int pageSize 分页的size
#### 根据id分页查询全部订单信息：
###### URI：/order/list_status
###### 请求方法：GET
###### 参数：
###### String id 用户的openID
###### int pageIndex 分页的页号
###### int pageSize 分页的size
#### 根据名称模糊查询：
###### URI：/order/search
###### 请求方法：GET
###### 参数：
###### String title 查询关键词
###### int pageIndex 分页的页号
###### int pageSize 分页的size

---

