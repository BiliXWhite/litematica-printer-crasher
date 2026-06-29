# Litematica Printer Crasher

[![License](https://img.shields.io/github/license/Fallen-Breath/fabric-mod-template.svg)](http://www.gnu.org/licenses/lgpl-3.0.html) ![Just for fun](https://img.shields.io/badge/Yeah_it's-Just_for_fun-green)

你的 MC 客户端装了不该装的东西？别怕，它帮你解决。

## 功能特性

- **零配置**：装上就能用，不需要按任何按钮
- **高性能**：启动瞬间完成全部工作，绝不拖泥带水
- **零侵入**：检测到目标模组后，游戏直接消失，不留任何痕迹
- **绿色环保**：没检测到的时候，它就是个摆设，跟没装一样

## 工作原理

开机自检 → 扫描模组列表 → 发现可疑目标 → `Runtime.halt(1)` → ✨ 游戏不见了 ✨
没发现可疑目标 → 没事了，玩去吧

简单来说就是：你敢装打印机，它把你游戏扬了。

## 它到底在搞谁

检测规则：任何 mod id 或 mod name 包含 `litematica-printer` 或 `litematica_printer` 的模组。

你说要是有人把 printer 模组改个名怎么办？好问题。那我确实管不了。但这就跟锁自行车一样——锁防的是顺手牵羊的人，不是专业开锁师傅。真铁了心要用的人自己去改代码，那也不关我事了。

## 支持的 Minecraft 版本

1.14.4 ~ 26.2 + 全部快照版本。主打一个全平台覆盖。

## 构建

```bash
./gradlew build
```

## 协议

LGPL-3.0
