# How to setup MySQL?

1. Go to [MySql downloader](https://dev.mysql.com/downloads/installer/) and choose your operating system and proceed to download.

![1693487282276](image/readme/1693487282276.png "MySQL download page")

![1693487608580](image/readme/1693487608580.png)

2. Open the installer and proceed with installation.
3. For a localhost choose do a full installation and click next.

   ![1693487752081](image/readme/1693487752081.png)
4. Click execute. After installation click next.

   ![1693487851202](image/readme/1693487851202.png)
5. Click next.

   ![1693488769646](image/readme/1693488769646.png)

   ![1693488793344](image/readme/1693488793344.png)
6. Setup root user password. Click next

   ![1693488850124](image/readme/1693488850124.png)
7. Click next. (OPTIONAL: Uncheck : Start the MySQL Server at System Startup)

   ![1693488957393](image/readme/1693488957393.png)
8. Click execute.

   ![1693488993292](image/readme/1693488993292.png)
9. Click finish

   ![1693489031709](image/readme/1693489031709.png)
10. Click next.

    ![1693489071807](image/readme/1693489071807.png)
11. Click finish.

    ![1693489089532](image/readme/1693489089532.png)
12. Enter the root user password (Which we setup early) and click check.

    ![1693489140680](image/readme/1693489140680.png)
13. Click next and then execute.

    ![1693489162045](image/readme/1693489162045.png)
14. Click finish

    ![1693489195007](image/readme/1693489195007.png)
15. Click finish.

    ![1693489242437](image/readme/1693489242437.png)
16. Congratulations! MySQL for localhost is setup.

# Using MySQL to run .sql file

1. Open MySQL Workbench

   ![1693489445581](image/readme/1693489445581.png)
2. Open local instance server.

   ![1693489484777](image/readme/1693489484777.png)
3. Enter root password to gain access.

   ![1693489505218](image/readme/1693489505218.png)
4. SQL queries can be run here.

   ![1693489610451](image/readme/1693489610451.png)
5. Select the script snippet which has to be run and click on run selected script.

   ![1693489800419](image/readme/1693489800419.png)

# Using Eclipse to add required files

1. Open eclipse workspace
2. Open this folder (Spring Dale College)
3. Right click on the folder name in eclipse
4. Click on build path > Configure build path > libraries
5. Click on ModulePath
6. Click on Add External JARs

   ![1695799806721](image/readme/1695799806721.png)
7. Browse for Spring Dale College > mysql-connector-j-8.1.0.jar
8. Click open and then apply and close.
9. We are ready to go.

![1695801056283](image/readme/1695801056283.png)

10. Run the client.java file
11. For the first time login with the database admin credentials (i.e with the root user which we created earlier in MySQL Workbench.
