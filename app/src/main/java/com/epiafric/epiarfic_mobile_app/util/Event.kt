package com.epiafric.epiarfic_mobile_app.util

/**
 * Created by ChukwuwaUchhenna
 *  Utility class for [LiveData] that handles single event scenarios
 */

class Event<out T>(private val content : T) {
    var eventHandled = false
    private set // Allow external read but not write

    /**
     * Returns the content and prevents its use again.
     */

    fun getContentIfEventNotHandled(): T?{
        return if(eventHandled){
            null
        }else{
            eventHandled = true
            content
        }
    }

    /**
     * Returns the content, even if it's already been handled.
     */
    fun peekContent(): T = content

}