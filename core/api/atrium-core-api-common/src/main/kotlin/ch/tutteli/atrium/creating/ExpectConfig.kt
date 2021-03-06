package ch.tutteli.atrium.creating

import ch.tutteli.atrium.reporting.translating.Translatable


@Experimental
@Retention(AnnotationRetention.BINARY)
@Target(AnnotationTarget.CLASS)
annotation class ExperimentalExpectConfig

//TODO #280 add doc
@ExperimentalExpectConfig
interface BaseExpectConfig {
    val description: Translatable
    val representation: Any?
}

//TODO #280 add doc
@ExperimentalExpectConfig
interface RootExpectConfig : BaseExpectConfig {
    companion object {
        fun create(description: Translatable, representation: Any?): RootExpectConfig =
            ExpectConfig(description, representation)
    }
}

//TODO #280 add doc
@ExperimentalExpectConfig
interface FeatureExpectConfig : BaseExpectConfig {
    companion object {
        fun create(description: Translatable, representation: Any?): FeatureExpectConfig =
            ExpectConfig(description, representation)
    }
}

@ExperimentalExpectConfig
private data class ExpectConfig(
    override val description: Translatable,
    override val representation: Any?
) : FeatureExpectConfig,
    RootExpectConfig
