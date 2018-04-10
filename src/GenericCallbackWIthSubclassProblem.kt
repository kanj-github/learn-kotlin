interface BaseUi {}

interface DerivedUi : BaseUi {}

interface BaseCallback<in T : BaseUi> {
    fun onUiReady(ui: T)
}

interface DerivedCallback<T : DerivedUi> : BaseCallback<T> {
    fun onSomeAction()
}

open class BaseUiImpl<U : BaseUi, T : BaseCallback<U>> : BaseUi {
    val callback: T

    constructor(callback: T) {
        this.callback = callback
    }

    fun makeUi() {
        callback.onUiReady(this as U)
    }
}

class DerivedUiImpl<T : DerivedCallback<DerivedUi>> : BaseUiImpl<DerivedUi, T>, DerivedUi {
    constructor(callback: T) : super(callback) {
    }
}

class DerivedUiCallbackImpl : DerivedCallback<DerivedUi> {
    override fun onUiReady(ui: DerivedUi) {
    }

    override fun onSomeAction() {
    }
}

fun main(args: Array<String>) {
    DerivedUiImpl<DerivedUiCallbackImpl>(DerivedUiCallbackImpl()).makeUi()
}