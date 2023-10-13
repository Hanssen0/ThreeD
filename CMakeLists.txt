cmake_minimum_required (VERSION 2.8)

find_package(Java REQUIRED)
include(UseJava)

project (ThreeD)

set(CMAKE_JAVA_COMPILE_FLAGS "-source" "8" "-target" "8")

add_jar(ThreeD SOURCES Main.java ThreeD/Engine/Renderer.java
  ThreeD/Engine/Space.java ThreeD/Engine/Camera.java ThreeD/Linear/Vector.java
  ThreeD/Linear/Matrix.java ThreeD/Engine/FileReader.java)
