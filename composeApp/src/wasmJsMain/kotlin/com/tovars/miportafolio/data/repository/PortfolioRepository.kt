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
        role = "Software Engineer | Mobile Developer",
        subtitle = "Especializado en Android Nativo, Kotlin Multiplatform e Inteligencia Artificial.",
        description = "Desarrollador de software multiplataforma con experiencia profesional en desarrollo Android nativo, Kotlin Multiplatform y Flutter, especializado en arquitecturas modernas, interfaces avanzadas, optimización de rendimiento, multimedia y soluciones escalables. Actualmente se desempeña como Desarrollador Android Full Time en ReadyChatAI.llc.",
        specialties = listOf(
            Specialty(
                title = "Android & KMP",
                description = "Dominio avanzado de Jetpack Compose y Kotlin Multiplatform. Creación de aplicaciones escalables compartiendo lógica de negocio entre Android, Desktop y Web.",
                color = Color(0xFF3DDC84)
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
            ),
            Specialty(
                title = "Automatización & Web",
                description = "Experiencia en web scraping, automatización de procesos y procesamiento de datos complejos desde formatos como HTML, XML y PDF.",
                color = Color(0xFFF59E0B)
            )
        ),
        projects = listOf(
            Project(
                title = "Mis Notas Uniguajira",
                description = "Plataforma móvil académica líder para estudiantes de la Universidad de La Guajira. Facilita la consulta de registros académicos, horarios y rendimiento académico en tiempo real.",
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
                tags = listOf("IoT", "Retrofit", "Firebase", "MVVM"),
                isLive = true
            ),
            Project(
                title = "Next-Gen Chat App",
                description = "Solución de mensajería instantánea escalable con enfoque en seguridad y baja latencia.",
                highlights = listOf(
                    "Inyección de dependencias profesional con Dagger Hilt.",
                    "Sincronización de datos global mediante Firebase Realtime Database.",
                    "Código altamente mantenible siguiendo estándares MVVM 2026."
                ),
                tags = listOf("Dagger Hilt", "Firebase", "MVVM", "Compose"),
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
                role = "Desarrollador Android",
                company = "ReadyChatAI.llc",
                period = "Octubre 2025 - Actualidad",
                location = "Remoto",
                description = "Ingeniería de software enfocada en soluciones de comunicación inteligente y escalabilidad de productos móviles.",
                highlights = listOf(
                    "Translate Text: Integración de motores de traducción por IA en flujos de mensajería.",
                    "AIReply: Automatización de respuestas mediante LLMs y prompts personalizados.",
                    "Arquitectura MVVM avanzada, inyección de dependencias y optimización de recomposición en Compose.",
                    "Garantía de persistencia mediante migraciones seguras en Room Database."
                ),
                technologies = listOf("Kotlin", "Compose", "MVVM", "AI Integration", "Room"),
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
                description = "Especialista en la creación de herramientas para la optimización de procesos y digitalización de datos.",
                highlights = listOf(
                    "Automatización de flujos de trabajo mediante técnicas de extracción y parsing de datos.",
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
                degree = "DESARROLLO DE IOT CON INTERFAZ EN MICROCONTROLADORES",
                institution = "Universidad de La Guajira",
                period = "2023 - 2024"
            )
        )
    )

    private fun getEnglishData() = AboutMe(
        name = "Said Tovar",
        role = "Software Engineer | Mobile Developer",
        subtitle = "Specialized in Native Android, Kotlin Multiplatform, and AI.",
        description = "Cross-platform software developer with professional experience in native Android, Kotlin Multiplatform, and Flutter. Specialized in modern architectures, advanced interfaces, performance optimization, multimedia, and scalable solutions. Currently working as a Full-Time Android Developer at ReadyChatAI.llc.",
        specialties = listOf(
            Specialty(
                title = "Android & KMP",
                description = "Advanced mastery of Jetpack Compose and Kotlin Multiplatform. Building scalable apps sharing business logic across Android, Desktop, and Web.",
                color = Color(0xFF3DDC84)
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
            ),
            Specialty(
                title = "Automation & Web",
                description = "Experience in web scraping, process automation, and complex data processing from HTML, XML, and PDF formats.",
                color = Color(0xFFF59E0B)
            )
        ),
        projects = listOf(
            Project(
                title = "Mis Notas Uniguajira",
                description = "Academic platform for students at University of La Guajira, validated with real users and constantly evolving.",
                highlights = listOf(
                    "Academic data parsing from HTML",
                    "PDF and institutional resource visualization",
                    "Student UX optimization"
                ),
                tags = listOf("Android", "Parsing", "UX"),
                isLive = true
            ),
            Project(
                title = "Guajira Connect",
                description = "Local social platform and marketplace designed to boost local businesses with scalable architecture.",
                highlights = listOf(
                    "Recommendation algorithms",
                    "Scalable architecture for high concurrency",
                    "Social media mechanics integration"
                ),
                tags = listOf("KMP", "Marketplace", "Social"),
                isLive = false
            ),
            Project(
                title = "Multimedia Engine KMP",
                description = "Cross-platform multimedia processing engine focusing on streaming and real-time analysis.",
                highlights = listOf(
                    "Amplitude and waveform extraction",
                    "Progressive audio streaming",
                    "Minimal OS dependency"
                ),
                tags = listOf("KMP", "Multimedia", "Real-time"),
                isLive = true
            )
        ),
        experience = listOf(
            Experience(
                role = "Android Developer",
                company = "ReadyChatAI.llc",
                period = "October 2025 - Present",
                location = "Remote",
                description = "Development of modern Android apps focused on communication and AI, collaborating directly on key products.",
                highlights = listOf(
                    "Translate Text: An SMS/MMS messaging manager with integrated intelligent translation.",
                    "AIReply: SMS application with personalized automatic replies via AI prompts.",
                    "Implementation of complex interfaces with Jetpack Compose and state optimization.",
                    "Advanced Room Database management and design of robust migrations."
                ),
                technologies = listOf("Kotlin", "Compose", "Room", "Coroutines", "AI Integration")
            ),
            Experience(
                role = "Freelance Developer",
                company = "Automation & Development",
                period = "Freelance Experience",
                location = "Colombia",
                description = "Creation of custom solutions focused on automation and data extraction.",
                highlights = listOf(
                    "Web scraping and web process automation",
                    "Excel/PDF file processing and manipulation",
                    "Cross-platform productivity tool development"
                ),
                technologies = listOf("Jsoup", "Requests", "Python", "Kotlin")
            ),
            Experience(
                role = "Support Engineer",
                company = "Technical Support",
                period = "Previous Experience",
                location = "Colombia",
                description = "Resolution of technical incidents and user-oriented support.",
                highlights = listOf(
                    "Technical diagnosis and error documentation",
                    "Internal support process optimization"
                )
            )
        ),
        education = listOf(
            Education(
                degree = "Software Engineering",
                institution = "University of La Guajira",
                period = "July 2018 - November 2023"
            ),
            Education(
                degree = "IoT DEVELOPMENT WITH MICROCONTROLLER INTERFACE",
                institution = "University of La Guajira",
                period = "2023 - 2024"
            )
        )
    )
}
