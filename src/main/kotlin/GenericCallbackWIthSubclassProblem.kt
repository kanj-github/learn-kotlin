interface BaseUi {}

interface DerivedUi : BaseUi {}

interface BaseCallback<in T : BaseUi> {
    fun onUiReady(ui: T)
}

interface DerivedCallback : BaseCallback<DerivedUi> {
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

class DerivedUiImpl : BaseUiImpl<DerivedUi, DerivedCallback>, DerivedUi {
    constructor(callback: DerivedCallback) : super(callback) {
    }
}

class DerivedUiCallbackImpl : DerivedCallback {
    override fun onUiReady(ui: DerivedUi) {
    }

    override fun onSomeAction() {
    }
}

fun main(args: Array<String>) {
    DerivedUiImpl(DerivedUiCallbackImpl()).makeUi()
}