# 🚀 Template Android MVVM Architecture

Este projeto é um **template base** desenvolvido para acelerar a criação de novos aplicativos Android. Ele utiliza as práticas mais modernas recomendadas pelo Google, focando em **Clean Architecture**, **MVVM**, e uma estrutura modular e testável.

O objetivo principal é fornecer uma base sólida onde toda a configuração pesada (Banco de dados, Injeção de Dependência, Mapeamento de dados) já esteja pronta para uso.

---

## 📍 Por onde comecei?

O projeto foi iniciado com a ideia de criar um **esqueleto reutilizável**. Em vez de configurar o Room, Hilt e a estrutura de pastas do zero em cada novo app, este template já traz:
1.  **Configuração de Build:** Gradle configurado com Version Catalogs (`libs.versions.toml`).
2.  **Abstração de Dados:** Uma entidade "Base" que serve de modelo para ser renomeada e expandida conforme a necessidade do novo aplicativo (ex: Tarefas, Gastos, Notas).
3.  **Padronização de Nomenclatura:** Uso do prefixo `Base` em todas as camadas para facilitar a identificação de onde as mudanças devem ocorrer.

---

## 🛠️ O que o projeto faz?

Atualmente, o projeto implementa um fluxo completo de **CRUD (Create, Read, Update, Delete)** persistente:
-   **Persistência Local:** Salva dados no banco de dados SQLite via Room.
-   **Reatividade:** A interface é atualizada automaticamente quando os dados no banco mudam, usando `Flow` e `StateFlow`.
-   **Desacoplamento:** A camada de UI não conhece o banco de dados; ela interage apenas com o `ViewModel`, que por sua vez fala com uma interface de `Repository`.
-   **Conversão de Dados:** Mapeia entidades de banco de dados para modelos de domínio, garantindo que mudanças no banco não quebrem a lógica de negócio.

---

## 🔄 Fluxo Detalhado do App

O fluxo segue uma direção unidirecional, garantindo previsibilidade:

1.  **UI (Jetpack Compose):** 
    - O usuário interage com a tela (ex: clica em "Salvar").
    - A View observa o `StateFlow` exposto pelo `BaseViewModel` para desenhar os itens na tela.

2.  **ViewModel (BaseViewModel):**
    - Recebe a ação da UI.
    - Processa dados simples (como capturar a data atual com `LocalDate`).
    - Dispara uma Coroutine no `viewModelScope` para chamar o Repository.

3.  **Domain Layer (BaseRepository & Base Model):**
    - Define o contrato (`interface`) de como os dados devem ser acessados.
    - Contém o modelo de dados puro (`Base.kt`), sem dependências de frameworks externos.

4.  **Data Layer (RepositoryImpl, DAO & Entity):**
    - O `BaseRepositoryImpl` recebe o comando.
    - Ele utiliza o `BaseMapper` para converter o modelo de domínio para uma `BaseEntity`.
    - Chama o `BaseDao` para executar a operação no Room (SQLite).
    - O resultado flui de volta de forma reativa através de um `Flow<List<Base>>`.

---

## 📂 Estrutura de Pastas

```text
com.example.templatebase/
├── data/               # Implementação técnica e persistência
│   ├── local/          # Configuração Room (Entity, DAO, Database)
│   ├── mapper/         # Conversores (Entity <-> Domain)
│   └── repository/     # Implementação dos repositórios
├── domain/             # Coração do negócio (regras puras)
│   ├── model/          # Modelos de dados de negócio
│   └── repository/     # Interfaces dos repositórios
├── ui/                 # Camada de Apresentação
│   ├── presentation/   # ViewModels e Componentes de tela
│   │   ├── viewmodel/
│   │   └── screen/
│   └── theme/          # Definições de cores e estilos (Compose)
├── di/                 # Injeção de Dependência (Hilt Modules)
└── App.kt              # Classe Application (Inicializa o Hilt)
```

---

## ✨ Tecnologias

- **Jetpack Compose:** UI declarativa.
- **Hilt (Dagger):** Injeção de dependência simplificada.
- **Room:** Abstração de banco de dados SQLite.
- **Coroutines & Flow:** Programação assíncrona e reativa.
- **ViewModel & Lifecycle:** Gerenciamento de estado consciente do ciclo de vida.

---

## 🚀 Como usar este template

1.  Renomeie o pacote `com.example.templatebase` para o nome do seu novo projeto.
2.  No pacote `domain/model`, altere a classe `Base` para sua entidade real.
3.  Atualize o `BaseDao` e `BaseEntity` com os novos campos.
4.  Use o `BaseViewModel` como exemplo para criar suas telas.

---
*Este projeto foi construído para ser o ponto de partida ideal para qualquer app que precise de organização e escalabilidade.*
