import SwiftUI
import composeApp

@main
struct iOSApp: App {
    init(){
        FirebaseInitKt.doInitFirebase()
        super.init()

    }

    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}