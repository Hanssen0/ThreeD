cmake_minimum_required (VERSION 2.8)

find_package(Java REQUIRED)
include(UseJava)

project (ThreeD)

set(CMAKE_JAVA_COMPILE_FLAGS "-source" "7" "-target" "7")

add_jar(ThreeD SOURCES Main.java ThreeD/Engine/Renderer.java ThreeD/Engine/Space.java ThreeD/Linear/Vector2D.java ThreeD/Linear/Vector3D.java)
