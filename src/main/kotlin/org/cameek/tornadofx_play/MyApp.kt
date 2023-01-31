package org.cameek.tornadofx_play

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.ConfigurableApplicationContext
import tornadofx.*
import kotlin.reflect.KClass
import kotlin.system.exitProcess

@SpringBootApplication
class MyApp: App(MyView::class) {

    private lateinit var context: ConfigurableApplicationContext

    init {

        importStylesheet("/customStyle.css")

        // CSS Reload for DEV
        // https://docs.tornadofx.io/0_subsection/6_css
        reloadStylesheetsOnFocus()
    }

    override fun init() {
        this.context = SpringApplication.run(this.javaClass) //We start the application context and let Spring Boot to initialize itself
        context.autowireCapableBeanFactory.autowireBean(this) //We ask the context to inject all needed dependencies into the current instance (if needed)

        FX.dicontainer = object : DIContainer { // Here we have to implement an interface for TornadoFX DI support
            override fun <T : Any> getInstance(type: KClass<T>): T = context.getBean(type.java) // We find dependencies directly in Spring's application context
            override fun <T : Any> getInstance(type: KClass<T>, name: String): T = context.getBean(name, type.java)
        }
    }

    override fun stop() { // On stop, we have to stop spring as well
        super.stop()
        context.close()
        exitProcess(0)
    }
}