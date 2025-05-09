// swift-tools-version: 5.9
import PackageDescription

let package = Package(
    name: "AppNativeInfo",
    platforms: [.iOS(.v13)],
    products: [
        .library(
            name: "AppNativeInfo",
            targets: ["NativeAppInfoPlugin"])
    ],
    dependencies: [
        .package(url: "https://github.com/ionic-team/capacitor-swift-pm.git", branch: "main")
    ],
    targets: [
        .target(
            name: "NativeAppInfoPlugin",
            dependencies: [
                .product(name: "Capacitor", package: "capacitor-swift-pm"),
                .product(name: "Cordova", package: "capacitor-swift-pm")
            ],
            path: "ios/Sources/NativeAppInfoPlugin"),
        .testTarget(
            name: "NativeAppInfoPluginTests",
            dependencies: ["NativeAppInfoPlugin"],
            path: "ios/Tests/NativeAppInfoPluginTests")
    ]
)