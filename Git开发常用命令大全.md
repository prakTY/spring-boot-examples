# Git 开发常用命令大全

## 📚 目录

- [基础命令](#基础命令)
- [配置管理](#配置管理)
- [仓库操作](#仓库操作)
- [文件操作](#文件操作)
- [提交操作](#提交操作)
- [分支管理](#分支管理)
- [远程操作](#远程操作)
- [合并操作](#合并操作)
- [撤销操作](#撤销操作)
- [查看操作](#查看操作)
- [标签管理](#标签管理)
- [暂存操作](#暂存操作)
- [子模块管理](#子模块管理)
- [常用场景](#常用场景)
- [最佳实践](#最佳实践)

***

## 基础命令

### 初始化和克隆

```bash
# 初始化新仓库
git init

# 克隆远程仓库
git clone <repository-url>g

# 克隆指定分支
git clone -b <branch-name> <repository-url>

# 克隆到指定目录
git clone <repository-url> <directory-name>

# 浅克隆（只获取最新提交）
git clone --depth 1 <repository-url>
```

### 帮助和版本

```bash
# 查看Git版本
git --version

# 查看命令帮助
git help <command>
git <command> --help

# 查看所有Git命令
git help -a
```

***

## 配置管理

### 用户配置

```bash
# 配置用户名
git config --global user.name "Your Name"

# 配置邮箱
git config --global user.email "your.email@example.com"

# 查看配置
git config --list

# 查看特定配置
git config user.name

# 编辑配置文件
git config --global --edit
```

### 别名配置

```bash
# 设置常用别名
git config --global alias.st status
git config --global alias.co checkout
git config --global alias.br branch
git config --global alias.ci commit
git config --global alias.un 'reset --hard HEAD'
git config --global alias.last 'log -1 HEAD'
git config --global alias.lg "log --color --graph --pretty=format:'%Cred%h%Creset -%C(yellow)%d%Creset %s %Cgreen(%cr) %C(bold blue)<%an>%Creset' --abbrev-commit"

# 查看所有别名
git config --global alias
```

### 其他配置

```bash
# 设置默认分支名称
git config --global init.defaultBranch main

# 设置编辑器
git config --global core.editor vim

# 设置合并工具
git config --global merge.tool vimdiff

# 设置差异工具
git config --global diff.tool vimdiff

# 设置文件名大小写敏感
git config --global core.ignorecase false

# 设置自动换行符转换
git config --global core.autocrlf input  # Windows
git config --global core.autocrlf input  # Linux/Mac
```

***

## 仓库操作

### 状态和信息

```bash
# 查看仓库状态
git status

# 查看仓库信息
git remote -v

# 查看当前分支
git branch

# 查看所有分支（包括远程）
git branch -a

# 查看最近提交
git log

# 查看简洁日志
git log --oneline

# 查看图形化日志
git log --graph --oneline --all

# 查看提交统计
git log --stat

# 查看文件变更
git log --name-status
```

### 清理和维护

```bash
# 清理未跟踪的文件
git clean -f

# 清理未跟踪的文件和目录
git clean -fd

# 预览清理操作
git clean -n

# 垃圾回收
git gc

# 验证仓库完整性
git fsck

# 重建索引
git update-index --refresh
```

***

## 文件操作

### 添加和删除

```bash
# 添加指定文件
git add <file-name>

# 添加所有文件
git add .

# 添加所有修改的文件
git add -u

# 添加所有文件（包括删除）
git add -A

# 交互式添加
git add -i

# 删除文件
git rm <file-name>

# 删除目录
git rm -r <directory-name>

# 删除文件但保留本地
git rm --cached <file-name>

# 移动/重命名文件
git mv <old-name> <new-name>
```

### 查看差异

```bash
# 查看工作区和暂存区的差异
git diff

# 查看暂存区和上一次提交的差异
git diff --staged
git diff --cached

# 查看指定文件的差异
git diff <file-name>

# 查看两次提交之间的差异
git diff <commit1> <commit2>

# 查看分支差异
git diff <branch1> <branch2>

# 查看差异统计
git diff --stat
```

### 恢复文件

```bash
# 恢复工作区文件（丢弃修改）
git checkout -- <file-name>
git restore <file-name>

# 恢复暂存区文件
git reset HEAD <file-name>
git restore --staged <file-name>

# 从指定提交恢复文件
git checkout <commit> -- <file-name>
git restore --source=<commit> <file-name>
```

***

## 提交操作

### 基本提交

```bash
# 提交暂存区更改
git commit -m "commit message"

# 提交所有修改的文件
git commit -am "commit message"

# 修改最后一次提交
git commit --amend

# 修改最后一次提交信息
git commit --amend -m "new message"

# 空提交（用于触发CI）
git commit --allow-empty -m "trigger build"
```

### 交互式提交

```bash
# 交互式暂存
git add -i

# 交互式提交
git commit -i

# 选择性提交
git add -p <file-name>
```

### 查看提交

```bash
# 查看提交详情
git show <commit>

# 查看提交文件
git show <commit>:<file>

# 查看提交历史
git log

# 查看指定作者的提交
git log --author="author name"

# 查看指定时间段的提交
git log --since="2024-01-01" --until="2024-12-31"

# 查看提交历史图
git log --graph --oneline --decorate --all
```

***

## 分支管理

### 创建和切换

```bash
# 创建新分支
git branch <branch-name>

# 创建并切换到新分支
git checkout -b <branch-name>
git switch -c <branch-name>

# 切换分支
git checkout <branch-name>
git switch <branch-name>

# 切换到上一个分支
git checkout -
git switch -

# 基于指定提交创建分支
git branch <branch-name> <commit>

# 基于远程分支创建本地分支
git checkout -b <branch-name> origin/<branch-name>
git switch -c <branch-name> origin/<branch-name>
```

### 查看分支

```bash
# 查看本地分支
git branch

# 查看远程分支
git branch -r

# 查看所有分支
git branch -a

# 查看分支详情
git branch -v

# 查看分支包含的提交
git branch --contains <commit>

# 查看分支合并状态
git branch --merged
git branch --no-merged
```

### 删除和重命名

```bash
# 删除本地分支
git branch -d <branch-name>

# 强制删除本地分支
git branch -D <branch-name>

# 删除远程分支
git push origin --delete <branch-name>
git push origin :<branch-name>

# 重命名分支
git branch -m <old-name> <new-name>

# 重命名当前分支
git branch -m <new-name>
```

### 分支比较

```bash
# 比较两个分支
git diff <branch1> <branch2>

# 查看分支包含的提交
git log <branch1> ^<branch2>

# 查看分支的共同祖先
git merge-base <branch1> <branch2>
```

***

## 远程操作

### 添加和查看

```bash
# 添加远程仓库
git remote add <name> <url>

# 查看远程仓库
git remote -v

# 查看指定远程仓库
git remote show <name>

# 重命名远程仓库
git remote rename <old-name> <new-name>

# 删除远程仓库
git remote remove <name>

# 修改远程仓库URL
git remote set-url <name> <new-url>
```

### 拉取和推送

```bash
# 拉取远程更新
git fetch

# 拉取指定远程仓库
git fetch <remote-name>

# 拉取并合并
git pull

# 拉取并变基
git pull --rebase

# 推送到远程仓库
git push

# 推送到指定远程仓库
git push <remote-name> <branch-name>

# 推送所有分支
git push --all

# 推送标签
git push --tags

# 强制推送
git push -f
git push --force

# 设置上游分支
git push -u <remote-name> <branch-name>
```

### 远程分支操作

```bash
# 拉取远程分支到本地
git fetch origin <branch-name>
git checkout <branch-name>

# 删除远程分支
git push origin --delete <branch-name>

# 清理已删除的远程分支
git remote prune origin
git fetch --prune
```

***

## 合并操作

### 基本合并

```bash
# 合并指定分支
git merge <branch-name>

# 合并但不提交
git merge --no-commit <branch-name>

# 合并并压缩提交
git merge --squash <branch-name>

# 中止合并
git merge --abort

# 继续合并
git merge --continue
```

### 变基操作

```bash
# 变基到指定分支
git rebase <branch-name>

# 交互式变基
git rebase -i <commit>

# 继续变基
git rebase --continue

# 跳过当前提交
git rebase --skip

# 中止变基
git rebase --abort

# 变基到指定提交
git rebase --onto <new-base> <upstream> <branch>
```

### 解决冲突

```bash
# 查看冲突文件
git status

# 查看冲突内容
git diff

# 标记冲突已解决
git add <file-name>

# 使用工具解决冲突
git mergetool

# 查看冲突标记
git diff --check
```

***

## 撤销操作

### 撤销工作区修改

```bash
# 撤销指定文件的修改
git checkout -- <file-name>
git restore <file-name>

# 撤销所有修改
git checkout .
git restore .

# 撤销未跟踪文件
git clean -f
```

### 撤销暂存区

```bash
# 撤销暂存区文件
git reset HEAD <file-name>
git restore --staged <file-name>

# 撤销所有暂存
git reset HEAD
git restore --staged .
```

### 撤销提交

```bash
# 撤销最后一次提交（保留修改）
git reset --soft HEAD~1

# 撤销最后一次提交（保留修改到工作区）
git reset HEAD~1

# 撤销最后一次提交（不保留修改）
git reset --hard HEAD~1

# 撤销到指定提交
git reset --hard <commit>

# 撤销到指定提交（保留修改）
git reset --soft <commit>

# 撤销到指定提交（保留修改到工作区）
git reset --mixed <commit>
```

### 撤销远程提交

```bash
# 撤销远程提交（危险操作）
git reset --hard HEAD~1
git push -f

# 使用revert撤销提交（推荐）
git revert <commit>
git push
```

### 恢复删除的提交

```bash
# 查看引用日志
git reflog

# 恢复删除的提交
git reset --hard <commit-from-reflog>

# 恢复删除的分支
git branch <branch-name> <commit-from-reflog>
```

***

## 查看操作

### 查看日志

```bash
# 查看提交历史
git log

# 查看简洁日志
git log --oneline

# 查看图形化日志
git log --graph --oneline --all

# 查看指定数量的提交
git log -n 10

# 查看指定文件的提交历史
git log --follow <file-name>

# 查看指定作者的提交
git log --author="author name"

# 查看提交统计
git log --stat

# 查看提交差异
git log -p
```

### 查看文件

```bash
# 查看文件内容
git show <commit>:<file>

# 查看文件历史
git log -p <file-name>

# 查看文件行历史
git blame <file-name>

# 查看指定行的历史
git blame -L <start>,<end> <file-name>
```

### 查看差异

```bash
# 查看工作区差异
git diff

# 查看暂存区差异
git diff --staged

# 查看指定提交的差异
git diff <commit1> <commit2>

# 查看分支差异
git diff <branch1> <branch2>

# 查看差异统计
git diff --stat

# 查看单词差异
git diff --word-diff
```

### 查看状态

```bash
# 查看仓库状态
git status

# 查看简洁状态
git status -s

# 查看分支状态
git status -sb

# 查看忽略的文件
git check-ignore -v <file-name>
```

***

## 标签管理

### 创建标签

```bash
# 创建轻量标签
git tag <tag-name>

# 创建附注标签
git tag -a <tag-name> -m "tag message"

# 为指定提交创建标签
git tag <tag-name> <commit>

# 创建带签名的标签
git tag -s <tag-name> -m "tag message"
```

### 查看标签

```bash
# 查看所有标签
git tag

# 查看标签详情
git show <tag-name>

# 查看匹配的标签
git tag -l "v1.*"

# 按提交显示标签
git tag --contains <commit>
```

### 推送标签

```bash
# 推送指定标签
git push origin <tag-name>

# 推送所有标签
git push --tags

# 推送所有标签和分支
git push --all --tags
```

### 删除标签

```bash
# 删除本地标签
git tag -d <tag-name>

# 删除远程标签
git push origin --delete <tag-name>
git push origin :refs/tags/<tag-name>
```

### 检出标签

```bash
# 检出标签
git checkout <tag-name>

# 基于标签创建分支
git checkout -b <branch-name> <tag-name>
```

***

## 暂存操作

### 保存和恢复

```bash
# 保存当前工作
git stash

# 保存并添加说明
git stash save "stash message"

# 保存未跟踪的文件
git stash -u

# 保存所有文件（包括忽略的）
git stash -a

# 查看暂存列表
git stash list

# 查看暂存详情
git stash show <stash-name>

# 查看暂存差异
git stash show -p <stash-name>
```

### 恢复暂存

```bash
# 恢复最近的暂存
git stash pop

# 恢复指定暂存
git stash pop <stash-name>

# 应用暂存但不删除
git stash apply

# 应用指定暂存
git stash apply <stash-name>

# 删除暂存
git stash drop <stash-name>

# 删除所有暂存
git stash clear
```

### 暂存分支

```bash
# 从暂存创建分支
git stash branch <branch-name> <stash-name>

# 查看暂存包含的文件
git stash show <stash-name>
```

***

## 子模块管理

### 添加和初始化

```bash
# 添加子模块
git submodule add <repository-url> <path>

# 初始化子模块
git submodule init

# 更新子模块
git submodule update

# 克隆包含子模块的项目
git clone --recursive <repository-url>
```

### 更新和管理

```bash
# 更新所有子模块
git submodule update --remote

# 更新指定子模块
git submodule update --remote <path>

# 拉取子模块最新代码
git submodule foreach git pull origin master

# 查看子模块状态
git submodule status
```

### 删除子模块

```bash
# 删除子模块
git submodule deinit <path>
git rm <path>
rm -rf .git/modules/<path>
```

***

## 常用场景

### 场景1：日常开发流程

```bash
# 1. 拉取最新代码
git pull origin main

# 2. 创建功能分支
git checkout -b feature/new-feature

# 3. 开发并提交
git add .
git commit -m "add new feature"

# 4. 推送到远程
git push -u origin feature/new-feature

# 5. 合并到主分支
git checkout main
git merge feature/new-feature
git push origin main

# 6. 删除功能分支
git branch -d feature/new-feature
git push origin --delete feature/new-feature
```

### 场景2：修复紧急bug

```bash
# 1. 保存当前工作
git stash

# 2. 切换到主分支
git checkout main

# 3. 创建修复分支
git checkout -b hotfix/urgent-bug

# 4. 修复并提交
git add .
git commit -m "fix urgent bug"

# 5. 合并到主分支
git checkout main
git merge hotfix/urgent-bug
git push origin main

# 6. 切换回功能分支
git checkout feature/new-feature

# 7. 恢复工作
git stash pop
```

### 场景3：代码审查流程

```bash
# 1. 开发者创建功能分支
git checkout -b feature/user-auth

# 2. 开发并提交
git add .
git commit -m "implement user authentication"

# 3. 推送到远程
git push -u origin feature/user-auth

# 4. 创建Pull Request/Merge Request

# 5. 审查者拉取代码
git fetch origin
git checkout feature/user-auth

# 6. 审查代码并提出修改意见

# 7. 开发者修改代码
git add .
git commit -m "address review comments"
git push

# 8. 审查通过后合并
git checkout main
git merge feature/user-auth
git push origin main
```

### 场景4：多人协作开发

```bash
# 1. 每个人创建自己的分支
git checkout -b feature/alice-feature
git checkout -b feature/bob-feature

# 2. 各自开发并提交
git add .
git commit -m "alice's feature"
git push -u origin feature/alice-feature

# 3. 定期同步主分支
git checkout main
git pull origin main

# 4. 合并主分支到功能分支
git checkout feature/alice-feature
git merge main

# 5. 解决冲突（如果有）
git add .
git commit -m "resolve merge conflicts"

# 6. 推送并创建Pull Request
git push origin feature/alice-feature
```

### 场景5：版本发布流程

```bash
# 1. 创建发布分支
git checkout -b release/v1.0.0

# 2. 更新版本号和文档
# 编辑相关文件

# 3. 提交更改
git add .
git commit -m "prepare for v1.0.0 release"

# 4. 创建标签
git tag -a v1.0.0 -m "Release version 1.0.0"

# 5. 合并到主分支
git checkout main
git merge release/v1.0.0
git push origin main

# 6. 推送标签
git push origin v1.0.0

# 7. 合并到开发分支
git checkout develop
git merge release/v1.0.0
git push origin develop

# 8. 删除发布分支
git branch -d release/v1.0.0
```

***

## 最佳实践

### 提交规范

```bash
# 提交信息格式
<type>(<scope>): <subject>

<body>

<footer>

# 类型（type）
feat: 新功能
fix: 修复bug
docs: 文档更新
style: 代码格式（不影响代码运行）
refactor: 重构
perf: 性能优化
test: 测试相关
chore: 构建/工具链相关

# 示例
feat(auth): add user login functionality

- Implement JWT authentication
- Add login form validation
- Create user session management

Closes #123
```

### 分支命名规范

```bash
# 功能分支
feature/<feature-name>
feature/user-authentication
feature/payment-gateway

# 修复分支
fix/<bug-description>
fix/login-error
fix/payment-timeout

# 热修复分支
hotfix/<urgent-bug>
hotfix/security-vulnerability
hotfix/crash-on-startup

# 发布分支
release/<version>
release/v1.0.0
release/v2.1.3

# 实验分支
experiment/<experiment-name>
experiment/new-ui-design
experiment/performance-test
```

### 工作流程

```bash
# Git Flow工作流程
1. main分支：生产环境代码
2. develop分支：开发环境代码
3. feature分支：新功能开发
4. release分支：发布准备
5. hotfix分支：紧急修复

# GitHub Flow工作流程
1. main分支：始终可部署
2. feature分支：从main创建，合并回main
3. Pull Request：代码审查

# GitLab Flow工作流程
1. main分支：生产环境
2. feature分支：功能开发
3. Merge Request：代码审查和合并
```

### 安全建议

```bash
# 1. 定期备份
git remote add backup <backup-url>
git push backup --all

# 2. 使用.gitignore
# 忽略敏感文件和临时文件

# 3. 签名提交
git config --global commit.gpgsign true
git config --global gpg.program gpg2

# 4. 保护重要分支
# 在GitHub/GitLab设置中保护main分支

# 5. 使用SSH密钥
# 配置SSH密钥进行安全认证
```

### 性能优化

```bash
# 1. 浅克隆大型仓库
git clone --depth 1 <repository-url>

# 2. 增量获取
git fetch --depth 1

# 3. 稀疏检出
git sparse-checkout init
git sparse-checkout set <directory>
git checkout

# 4. 垃圾回收
git gc --aggressive --prune=now

# 5. 优化仓库
git repack -a -d --depth=250 --window=250
```

***

## 常见问题解决

### 问题1：合并冲突

```bash
# 查看冲突文件
git status

# 手动解决冲突
# 编辑冲突文件，删除冲突标记

# 标记冲突已解决
git add <conflicted-file>

# 继续合并
git merge --continue

# 如果无法解决，中止合并
git merge --abort
```

### 问题2：误删文件恢复

```bash
# 查看删除记录
git log --diff-filter=D --summary

# 恢复删除的文件
git checkout <commit>~1 -- <deleted-file>
```

### 问题3：回退错误提交

```bash
# 查看提交历史
git log --oneline

# 回退到指定提交（保留修改）
git reset --soft <commit>

# 回退到指定提交（不保留修改）
git reset --hard <commit>

# 如果已推送，使用revert
git revert <commit>
git push
```

### 问题4：大文件处理

```bash
# 查找大文件
git rev-list --objects --all |
git cat-file --batch-check='%(objecttype) %(objectname) %(objectsize) %(rest)' |
awk '/^blob/ {print substr($0,6)}' |
sort -nk2 -r

# 使用Git LFS
git lfs track "*.psd"
git lfs track "*.zip"
git add .gitattributes
git commit -m "track large files"
```

### 问题5：子模块问题

```bash
# 子模块为空
git submodule update --init --recursive

# 子模块版本不对
git submodule update --remote

# 删除子模块
git submodule deinit <path>
git rm <path>
rm -rf .git/modules/<path>
```

***

## 工具和集成

### GUI工具

```bash
# 常用Git GUI工具
- GitKraken
- SourceTree
- TortoiseGit
- GitHub Desktop
- Git Cola
- Lazygit
```

### IDE集成

```bash
# IntelliJ IDEA
- 内置Git支持
- 可视化提交历史
- 便捷的分支管理

# VS Code
- Git扩展
- 可视化差异
- 内置终端

# Eclipse
- EGit插件
- 团队协作支持
```

### CI/CD集成

```bash
# GitHub Actions
- 自动化测试
- 自动部署
- 代码质量检查

# GitLab CI
- 持续集成
- 持续部署
- 环境管理

# Jenkins
- 灵活的流水线
- 插件生态
- 分布式构建
```

***

## 参考资源

### 官方文档

- [Git官方文档](https://git-scm.com/doc)
- [Pro Git书籍](https://git-scm.com/book/zh/v2)
- [GitHub Git指南](https://guides.github.com/)

### 在线教程

- [Learn Git Branching](https://learngitbranching.js.org/)
- [Git Immersion](https://gitimmersion.com/)
- [Oh Shit, Git!?!](https://ohshitgit.com/)

### 社区资源

- [Stack Overflow - Git](https://stackoverflow.com/questions/tagged/git)
- [Git subreddit](https://www.reddit.com/r/git/)
- [GitHub Community Forum](https://github.community/)

***

## 快速参考卡

### 日常开发

```bash
git pull                    # 拉取最新代码
git add .                   # 添加所有文件
git commit -m "message"      # 提交更改
git push                     # 推送到远程
git status                   # 查看状态
git log --oneline           # 查看日志
```

### 分支操作

```bash
git branch                  # 查看分支
git checkout -b <branch>     # 创建并切换分支
git merge <branch>          # 合并分支
git branch -d <branch>      # 删除分支
```

### 撤销操作

```bash
git checkout -- <file>       # 撤销文件修改
git reset HEAD <file>        # 撤销暂存
git reset --hard HEAD~1      # 撤销最后一次提交
```

### 远程操作

```bash
git remote add <name> <url> # 添加远程仓库
git fetch                   # 获取远程更新
git push -u origin <branch>  # 推送并设置上游
```

***

**最后更新：** 2024-01-18\
**Git版本：** 2.x+\
**适用平台：** Windows, Linux, macOS
