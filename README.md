##### Projeto simples para simular compras em um website de teste React

Framework utilizado:
- TestNG

Libs utilizadas:
- Selenium Webdriver;
- Selenide;
- Allure reports;

#### Sobre o projeto

Testes contemplados na classe CheckoutTests;

Reports sendo gerados na pasta allure-results, com Screenshots tiradas ao fim de cada Cenário.

Para exibir os relatórios, deve-se ter o allure-reports instalado no servidor ou local, é possível instalar com o npm com o comando:
```
$ npm install allure-commandline -g
```

Para exibir os relatórios Allure após execução dos testes, deve-se ir até a raíz do projeto e digitar:
```
$ allure serve
```