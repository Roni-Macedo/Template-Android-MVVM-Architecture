# Template Android MVVM Architecture

# 📱 Android MVVM Architecture Sample

Um projeto de exemplo Android moderno usando a arquitetura **MVVM**, com **Jetpack Compose**, **Room** para persistência local e **Hilt** para injeção de dependência. Ideal para aprendizado, referência ou como base para novos apps.

---

## ✨ Tecnologias Utilizadas

- **Kotlin**
- **Jetpack Compose** – UI moderna declarativa
- **Room** – Persistência local (SQLite)
- **ViewModel** – Gerenciamento de estado
- **Hilt** – Injeção de dependência
- **StateFlow** – Fluxo de dados reativo
- **Navigation-Compose** – Navegação entre telas

---

## 📱 Funcionalidades

- Adicionar itens (notas, tarefas, etc.)
- Editar itens existentes
- Excluir itens
- Listar todos os itens salvos
- Interface responsiva com Jetpack Compose
---

## 🧱 Arquitetura

Este projeto segue o padrão **MVVM (Model - View - ViewModel)** com separação em camadas claras:
-    templatebase/
-    ├── data/
-    │   ├── local/
-    │   │   ├── BaseEntity.kt
-    │   │   ├── BaseDao.kt
-    │   │   └── AppDatabase.kt
-    │   │
-    │   ├── mapper/
-    │   │   └── BaseMapper.kt
-    │   │
-    │   └── repository/
-    │       └── BaseRepositoryImpl.kt
-    │
-    ├── domain/
-    │   ├── model/
-    │   │   └── Base.kt
-    │   │
-    │   └── repository/
-    │       └── BaseRepository.kt
-    │
-    ├── presentation/
-    │   ├── viewmodel/
-    │   │   └── BaseViewModel.kt
-    │   │
-    │   └── screen/
-    │       └── BaseScreen.kt
-    │
-    ├── di/
-    │   └── AppModule.kt
-    │
-    └── BaseApp.kt

🧠 Aprendizados
Este projeto demonstra:

- Como aplicar o padrão MVVM em projetos Android modernos

- Como usar Room para persistência local

- Como implementar injeção de dependência com Hilt

- Como estruturar um app com camadas limpas e reutilizáveis

- Como criar interfaces com Jetpack Compose

🤝 Contribuição
Contribuições são bem-vindas! Sinta-se à vontade para abrir issues ou enviar pull requests.

🧑‍💻 Autor
Roni-Macedo
