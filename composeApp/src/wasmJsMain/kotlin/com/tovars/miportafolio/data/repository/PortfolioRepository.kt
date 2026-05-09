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
                description = "Plataforma académica para estudiantes de la Universidad de La Guajira, validada con usuarios reales y en constante evolución.",
                highlights = listOf(
                    "Parsing de datos académicos desde HTML",
                    "Visualización de PDFs y recursos institucionales",
                    "Optimización de la experiencia de usuario estudiantil"
                ),
                tags = listOf("Android", "Parsing", "UX"),
                isLive = true,
                url = "https://github.com/SaidTovar/AppMisDatosUniguajira"
            ),
            Project(
                title = "Guajira Connect",
                description = "Plataforma social y marketplace local diseñada para potenciar emprendimientos locales con arquitectura escalable.",
                highlights = listOf(
                    "Algoritmos de recomendación",
                    "Arquitectura escalable para alta concurrencia",
                    "Integración de mecánicas de red social"
                ),
                tags = listOf("KMP", "Marketplace", "Social"),
                isLive = false
            ),
            Project(
                title = "Multimedia Engine KMP",
                description = "Motor de procesamiento multimedia multiplataforma con enfoque en streaming y análisis en tiempo real.",
                highlights = listOf(
                    "Extracción de amplitudes y waveforms",
                    "Streaming progresivo de audio",
                    "Mínima dependencia del sistema operativo"
                ),
                tags = listOf("KMP", "Multimedia", "Real-time"),
                isLive = true
            )
        ),
        experience = listOf(
            Experience(
                role = "Desarrollador Android",
                company = "ReadyChatAI.llc",
                period = "Octubre 2025 - Actualidad",
                location = "Remoto",
                description = "Desarrollo de aplicaciones Android modernas enfocadas en comunicación e IA, colaborando directamente en productos clave de la compañía.",
                highlights = listOf(
                    "Colaboración en 'Translate Text': Un gestor de mensajería SMS/MMS con traducción inteligente integrada.",
                    "Colaboración en 'AIReply': Aplicación de SMS con respuestas automáticas personalizadas mediante prompts de IA.",
                    "Implementación de interfaces complejas con Jetpack Compose y optimización de estados.",
                    "Manejo avanzado de Room Database y diseño de migraciones robustas."
                ),
                technologies = listOf("Kotlin", "Compose", "Room", "Coroutines", "AI Integration"),
                companyUrl = "https://www.linkedin.com/company/readychataimessenger/posts/?feedView=all",
                playStoreUrls = listOf(
                    "Translate Text" to "https://play.google.com/store/apps/details?id=com.readychatai.translation_app",
                    "AIReply" to "https://play.google.com/store/apps/details?id=com.readychat.smsbase"
                )
            ),
            Experience(
                role = "Desarrollador Autónomo",
                company = "Automatización y Desarrollo",
                period = "Experiencia Independiente",
                location = "Colombia",
                description = "Creación de soluciones personalizadas enfocadas en automatización y extracción de datos.",
                highlights = listOf(
                    "Web scraping y automatización de procesos web",
                    "Procesamiento y manipulación de archivos Excel/PDF",
                    "Desarrollo de herramientas de productividad multiplataforma"
                ),
                technologies = listOf("Jsoup", "Requests", "Python", "Kotlin")
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
                    "Collaboration on 'Translate Text': An SMS/MMS messaging manager with integrated intelligent translation.",
                    "Collaboration on 'AIReply': SMS application with personalized automatic replies via AI prompts.",
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
            )
        )
    )
}
