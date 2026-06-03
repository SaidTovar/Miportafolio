package com.tovars.miportafolio.data.repository

import androidx.compose.ui.graphics.Color
import com.tovars.miportafolio.domain.model.*

interface PortfolioRepository {
    fun getAboutMe(language: Language): AboutMe
}

class PortfolioRepositoryImpl : PortfolioRepository {
    override fun getAboutMe(language: Language): AboutMe = when (language) {
        Language.ES -> getSpanishData()
        Language.EN -> getEnglishData()
    }

    private fun getSpanishData() = AboutMe(
        name = "Said Tovar",
        role = "Software Engineer | Android Developer",
        subtitle = "Especializado en Android Nativo y Kotlin Multiplatform.",
        description = "Ingeniero de Software especializado en el ecosistema Android con enfoque en Kotlin Multiplatform (KMP) y Jetpack Compose. Experto en el desarrollo de arquitecturas modernas, interfaces avanzadas y soluciones escalables.",
        specialties = listOf(
            Specialty(
                title = "Android & KMP",
                description = "Dominio avanzado de Jetpack Compose y Kotlin Multiplatform. Creación de aplicaciones escalables compartiendo lógica de negocio entre plataformas mediante Kotlin.",
                color = Color(0xFF3DDC84)
            ),
            Specialty(
                title = "Automatización & Web",
                description = "Experiencia en web scraping con Kotlin, automatización de procesos y procesamiento de datos complejos desde formatos como HTML, XML y PDF.",
                color = Color(0xFFF59E0B)
            ),
            Specialty(
                title = "IA & Multimedia",
                description = "Procesamiento de audio en tiempo real, streaming progresivo, visualización de waveforms e integración de APIs de IA para experiencias inteligentes.",
                color = Color(0xFF0EA5E9)
            ),
            Specialty(
                title = "Arquitectura & Datos",
                description = "Clean Architecture, MVVM, Room Database con migraciones robustas y optimización de rendimiento para aplicaciones en producción.",
                color = Color(0xFF7F52FF)
            )
        ),
        projects = listOf(
            Project(
                title = "Mis Notas Uniguajira",
                description = "Plataforma móvil académica para estudiantes de la Universidad de La Guajira. Facilita la consulta de registros académicos, horarios y rendimiento académico en tiempo real.",
                highlights = listOf(
                    "Más de 5,000 descargas activas en Google Play Store.",
                    "Implementación de Web Scraping avanzado para extracción de datos institucionales.",
                    "Arquitectura robusta basada en MVVM con Jetpack Compose y Firebase."
                ),
                tags = listOf("Kotlin", "Compose", "MVVM", "Firebase", "Web Scraping"),
                isLive = true,
                url = "https://github.com/SaidTovar/AppMisDatosUniguajira",
                imageUrl = "https://raw.githubusercontent.com/SaidTovar/AppMisDatosUniguajira/refs/heads/main/Mockup/5.png"
            ),
            Project(
                title = "InfoTools Desktop",
                description = "Software de alto rendimiento para la digitalización y procesamiento inteligente de información técnica en formato PDF.",
                highlights = listOf(
                    "Manipulación avanzada de documentos mediante PDFBox.",
                    "Generación y exportación de archivos estructurados basada en plantillas.",
                    "Desarrollo multiplataforma con Compose Desktop bajo patrón MVVM."
                ),
                tags = listOf("Kotlin", "Compose Desktop", "MVVM", "PDFBox"),
                isLive = true
            ),
            Project(
                title = "Air IoT Control",
                description = "Ecosistema de control inteligente para sistemas de climatización basado en Internet de las Cosas (IoT).",
                highlights = listOf(
                    "Comunicación en tiempo real y gestión de usuarios vía Firebase.",
                    "Integración eficiente con APIs REST mediante Retrofit.",
                    "Interfaz reactiva y moderna desarrollada íntegramente en Jetpack Compose."
                ),
                tags = listOf("Kotlin", "Retrofit", "Firebase", "MVVM"),
                isLive = true
            ),
            Project(
                title = "Next-Gen Chat App",
                description = "Solución de mensajería instantánea escalable con enfoque en seguridad y baja latencia.",
                highlights = listOf(
                    "Inyección de dependencias profesional con Dagger Hilt.",
                    "Sincronización de datos global mediante Firebase Realtime Database.",
                    "Código altamente mantenible siguiendo estándares MVVM."
                ),
                tags = listOf("Kotlin", "Dagger Hilt", "Firebase", "MVVM", "Compose"),
                isLive = true
            ),
            Project(
                title = "TallerDeConfecciones Manager",
                description = "Sistema integral de gestión de pedidos y logística de producción para entornos industriales de confección.",
                highlights = listOf(
                    "Implementación de flujos CRUD complejos con persistencia remota en MySQL.",
                    "Consumo eficiente de servicios mediante Retrofit.",
                    "Arquitectura MVVM para asegurar escalabilidad del producto."
                ),
                tags = listOf("Kotlin", "MySQL", "Retrofit", "MVVM"),
                isLive = true
            )
        ),
        experience = listOf(
            Experience(
                role = "Desarrollador Android (Kotlin & Jetpack Compose)",
                company = "ReadyChatAI.llc",
                period = "Octubre 2025 - Actualidad",
                location = "Remoto",
                description = "Desarrollo de soluciones móviles de alta concurrencia y gestión de datos en tiempo real. Colaboración en equipo multidisciplinar bajo metodologías ágiles.",
                highlights = listOf(
                    "Integración de LLMs: Optimización de la comunicación entre la aplicación móvil y servicios de IA (OpenAI/Gemini) mediante arquitecturas de proxy seguras.",
                    "Ingeniería de NLP: Procesamiento de lenguaje natural enfocado en la normalización de datos y manejo de variantes lingüísticas.",
                    "Gestión de JSON: Implementación de lógica para el manejo de salidas estructuradas asegurando la integridad de los datos.",
                    "Arquitectura: Mantenimiento y escalabilidad de sistemas basados en Clean Architecture y MVVM.",
                    "UI Declarativa: Creación de componentes reutilizables y vistas con Jetpack Compose y Material 3.",
                    "QA y Testing: Identificación proactiva de fallos y fortalecimiento de la estabilidad mediante pruebas unitarias con JUnit.",
                    "DI y Modularización: Gestión de dependencias con Dagger Hilt para optimizar la integración de módulos.",
                    "Persistencia Local: Almacenamiento eficiente mediante Room Database para disponibilidad offline.",
                    "Servicios Cloud: Implementación técnica para mensajería y sincronización en la nube.",
                    "Tareas Asíncronas: Optimización de procesos en segundo plano con WorkManager y Coroutines."
                ),
                technologies = listOf("Kotlin", "Jetpack Compose", "Dagger Hilt", "Clean Architecture", "MVVM", "Room", "JUnit", "WorkManager"),
                companyUrl = "https://www.linkedin.com/company/readychataimessenger/posts/?feedView=all",
                playStoreUrls = listOf(
                    "Translate Text" to "https://play.google.com/store/apps/details?id=com.readychatai.translation_app",
                    "AIReply" to "https://play.google.com/store/apps/details?id=com.readychat.smsbase"
                )
            ),
            Experience(
                role = "Desarrollador de Soluciones Autónomo",
                company = "Ingeniería y Automatización",
                period = "2022 - 2025",
                location = "Colombia",
                description = "Especialista en la creación de herramientas para la optimización de procesos y digitalización de datos utilizando Kotlin.",
                highlights = listOf(
                    "Más de 5 soluciones de software creadas para la automatización de flujos de trabajo mediante técnicas de extracción y parsing de datos.",
                    "Desarrollo de utilitarios multiplataforma para la manipulación de documentos y archivos de datos.",
                    "Diseño de arquitecturas escalables para aplicaciones de uso intensivo de datos."
                ),
                technologies = listOf("Kotlin", "MVVM", "Jsoup", "API REST")
            ),
            Experience(
                role = "Ingeniero de Soporte",
                company = "Soporte Tecnológico",
                period = "Experiencia Previa",
                location = "Colombia",
                description = "Resolución de incidencias técnicas y soporte orientado al usuario.",
                highlights = listOf(
                    "Diagnóstico técnico y documentación de errores",
                    "Optimización de procesos internos de soporte"
                )
            )
        ),
        education = listOf(
            Education(
                degree = "Ingeniería de Sistemas",
                institution = "Universidad de La Guajira",
                period = "Julio 2018 - Noviembre 2023"
            ),
            Education(
                degree = "DIPLOMADO DE DESARROLLO DE IOT CON INTERFAZ EN MICROCONTROLADORES",
                institution = "Universidad de La Guajira",
                period = "2023 - 2024"
            )
        ),
        contactInfo = ContactInfo(
            email = "saidtovar.dev@gmail.com",
            linkedinUrl = "https://www.linkedin.com/in/said-tovar-2b1b3b1b3/",
            githubUrl = "https://github.com/SaidTovar"
        )
    )

    private fun getEnglishData() = AboutMe(
        name = "Said Tovar",
        role = "Software Engineer | Android Developer",
        subtitle = "Specialized in Native Android, Kotlin Multiplatform, and AI.",
        description = "Software Engineer specialized in the Android ecosystem with a focus on Kotlin Multiplatform (KMP) and Jetpack Compose. Expert in developing modern architectures, advanced interfaces, and scalable solutions.",
        specialties = listOf(
            Specialty(
                title = "Android & KMP",
                description = "Advanced mastery of Jetpack Compose and Kotlin Multiplatform. Building scalable apps sharing business logic across platforms using Kotlin.",
                color = Color(0xFF3DDC84)
            ),
            Specialty(
                title = "Automation & Web",
                description = "Experience in web scraping with Kotlin, process automation, and complex data processing from HTML, XML, and PDF formats.",
                color = Color(0xFFF59E0B)
            ),
            Specialty(
                title = "AI & Multimedia",
                description = "Real-time audio processing, progressive streaming, waveform visualization, and AI API integration for intelligent experiences.",
                color = Color(0xFF0EA5E9)
            ),
            Specialty(
                title = "Architecture & Data",
                description = "Clean Architecture, MVVM, Room Database with robust migrations, and performance optimization for production apps.",
                color = Color(0xFF7F52FF)
            )
        ),
        projects = listOf(
            Project(
                title = "Mis Notas Uniguajira",
                description = "Academic mobile platform for students at the University of La Guajira. Facilitates the consultation of academic records, schedules, and academic performance in real time.",
                highlights = listOf(
                    "Over 5,000 active downloads on Google Play Store.",
                    "Implementation of advanced Web Scraping for institutional data extraction.",
                    "Robust architecture based on MVVM with Jetpack Compose and Firebase."
                ),
                tags = listOf("Kotlin", "Compose", "MVVM", "Firebase", "Web Scraping"),
                isLive = true,
                url = "https://github.com/SaidTovar/AppMisDatosUniguajira",
                imageUrl = "https://raw.githubusercontent.com/SaidTovar/AppMisDatosUniguajira/refs/heads/main/Mockup/5.png"
            ),
            Project(
                title = "InfoTools Desktop",
                description = "High-performance software for the digitization and intelligent processing of technical information in PDF format.",
                highlights = listOf(
                    "Advanced document manipulation using PDFBox.",
                    "Generation and export of structured files based on templates.",
                    "Cross-platform development with Compose Desktop under MVVM pattern."
                ),
                tags = listOf("Kotlin", "Compose Desktop", "MVVM", "PDFBox"),
                isLive = true
            ),
            Project(
                title = "Air IoT Control",
                description = "Intelligent control ecosystem for air conditioning systems based on the Internet of Things (IoT).",
                highlights = listOf(
                    "Real-time communication and user management via Firebase.",
                    "Efficient integration with REST APIs using Retrofit.",
                    "Modern reactive interface fully developed in Jetpack Compose."
                ),
                tags = listOf("Kotlin", "Retrofit", "Firebase", "MVVM"),
                isLive = true
            ),
            Project(
                title = "Next-Gen Chat App",
                description = "Scalable instant messaging solution with a focus on security and low latency.",
                highlights = listOf(
                    "Professional dependency injection with Dagger Hilt.",
                    "Global data synchronization via Firebase Realtime Database.",
                    "Highly maintainable code following MVVM standards."
                ),
                tags = listOf("Kotlin", "Dagger Hilt", "Firebase", "MVVM", "Compose"),
                isLive = true
            ),
            Project(
                title = "TallerDeConfecciones Manager",
                description = "Comprehensive order management and production logistics system for industrial garment environments.",
                highlights = listOf(
                    "Implementation of complex CRUD flows with remote MySQL persistence.",
                    "Efficient consumption of services using Retrofit.",
                    "MVVM architecture to ensure product scalability."
                ),
                tags = listOf("Kotlin", "MySQL", "Retrofit", "MVVM"),
                isLive = true
            )
        ),
        experience = listOf(
            Experience(
                role = "Android Developer (Kotlin & Jetpack Compose)",
                company = "ReadyChatAI.llc",
                period = "October 2025 - Present",
                location = "Remote",
                description = "Development of high-concurrency mobile solutions and real-time data management. Collaboration in multidisciplinary teams under agile methodologies.",
                highlights = listOf(
                    "LLM Integration: Optimizing communication between the mobile app and AI services (OpenAI/Gemini) through secure proxy architectures.",
                    "NLP Engineering: Natural language processing focused on data normalization and linguistic variant handling.",
                    "JSON Management: Implementation of logic for structured output handling, ensuring data integrity.",
                    "Architecture: Maintenance and scalability of systems based on Clean Architecture and MVVM.",
                    "Declarative UI: Creation of reusable components and views with Jetpack Compose and Material 3.",
                    "QA and Testing: Proactive failure identification and stability strengthening through unit testing with JUnit.",
                    "DI and Modularization: Dependency management with Dagger Hilt to optimize module integration.",
                    "Local Persistence: Efficient storage using Room Database for offline availability.",
                    "Cloud Services: Technical implementation for messaging and cloud synchronization.",
                    "Async Tasks: Optimization of background processes with WorkManager and Coroutines."
                ),
                technologies = listOf("Kotlin", "Jetpack Compose", "Dagger Hilt", "Clean Architecture", "MVVM", "Room", "JUnit", "WorkManager"),
                companyUrl = "https://www.linkedin.com/company/readychataimessenger/posts/?feedView=all",
                playStoreUrls = listOf(
                    "Translate Text" to "https://play.google.com/store/apps/details?id=com.readychatai.translation_app",
                    "AIReply" to "https://play.google.com/store/apps/details?id=com.readychat.smsbase"
                )
            ),
            Experience(
                role = "Autonomous Solutions Developer",
                company = "Engineering & Automation",
                period = "2022 - 2025",
                location = "Colombia",
                description = "Specialist in the creation of tools for process optimization and data digitization using Kotlin.",
                highlights = listOf(
                    "Over 5 software solutions created for work flow automation using data extraction and parsing techniques.",
                    "Development of cross-platform utilities for the manipulation of documents and data files.",
                    "Design of scalable architectures for data-intensive applications."
                ),
                technologies = listOf("Kotlin", "MVVM", "Jsoup", "API REST")
            ),
            Experience(
                role = "Support Engineer",
                company = "Technical Support",
                period = "Previous Experience",
                location = "Colombia",
                description = "Resolution of technical incidents and user-oriented support.",
                highlights = listOf(
                    "Technical diagnosis and error documentation",
                    "Optimization of internal support processes"
                )
            )
        ),
        education = listOf(
            Education(
                degree = "Systems Engineering",
                institution = "University of La Guajira",
                period = "July 2018 - November 2023"
            ),
            Education(
                degree = "DIPLOMA IN IOT DEVELOPMENT WITH MICROCONTROLLER INTERFACE",
                institution = "University of La Guajira",
                period = "2023 - 2024"
            )
        ),
        contactInfo = ContactInfo(
            email = "saidtovar.dev@gmail.com",
            linkedinUrl = "https://www.linkedin.com/in/said-tovar-2b1b3b1b3/",
            githubUrl = "https://github.com/SaidTovar"
        )
    )
}
