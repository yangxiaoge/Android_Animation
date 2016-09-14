# Android 动画

**郭霖动画三步走:**

1. [Android属性动画完全解析(上)，初识属性动画的基本用法 ](http://blog.csdn.net/guolin_blog/article/details/43536355), [demo](https://github.com/yangxiaoge/Android_Animation/blob/master/app/src/main/java/com/yang/bruce/android_animation/MainActivity.java)已完成
2. [Android属性动画完全解析(中)，ValueAnimator和ObjectAnimator的高级用法](http://blog.csdn.net/guolin_blog/article/details/43816093)
3. [Android属性动画完全解析(下)，Interpolator和ViewPropertyAnimator的用法](http://blog.csdn.net/guolin_blog/article/details/44171115)

支付宝最近的公告表示，从2016年10月12日起，支付宝将对个人的提现功能开始收取服务费，费率是0.1%，每个用户累计享有2万元的基础免费提现额度。

今年3月份微信开始收取提现服务费的时候支付宝曾公开表示将继续免费下去，结果短短半年的时间里，国内两大第三方支付机构集体沦陷。今后大额转账不管是通过支付宝还是微信，都不再划算了。另外需要注意，余额宝属于理财产品，不受此次提现服务费的影响，但通过余额购买的余额宝最终只能提现到余额，也就是无法通过余额宝的方式绕过服务费的收取。

`郭神写动画文章的背景:`

在手机上去实现一些动画效果算是件比较炫酷的事情，因此Android系统在一开始的时候就给我们提供了两种实现动画效果的方式，逐帧动画(frame-by-frame animation)和补间动画(tweened animation)。逐帧动画的工作原理很简单，其实就是将一个完整的动画拆分成一张张单独的图片，然后再将它们连贯起来进行播放，类似于动画片的工作原理。补间动画则是可以对View进行一系列的动画操作，包括淡入淡出、缩放、平移、旋转四种。

然而自Android 3.0版本开始，系统给我们提供了一种全新的动画模式，属性动画(property animation)，它的功能非常强大，弥补了之前补间动画的一些缺陷，几乎是可以完全替代掉补间动画了。对于逐帧动画和补间动画的用法，我不想再多讲，它们的技术已经比较老了，而且网上资料也非常多，那么今天我们这篇文章的主题就是对Android属性动画进行一次完全解析。