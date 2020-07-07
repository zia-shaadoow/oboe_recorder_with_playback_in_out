#----------------------------------------------------------------
# Generated CMake target import file for configuration "Debug".
#----------------------------------------------------------------

# Commands may need to know the format version.
set(CMAKE_IMPORT_FILE_VERSION 1)

# Import target "SndFile::sndfile" for configuration "Debug"
set_property(TARGET SndFile::sndfile APPEND PROPERTY IMPORTED_CONFIGURATIONS DEBUG)
set_target_properties(SndFile::sndfile PROPERTIES
  IMPORTED_LINK_INTERFACE_LANGUAGES_DEBUG "C"
  IMPORTED_LOCATION_DEBUG "${_IMPORT_PREFIX}/lib/libsndfile.a"
  )

list(APPEND _IMPORT_CHECK_TARGETS SndFile::sndfile )
list(APPEND _IMPORT_CHECK_FILES_FOR_SndFile::sndfile "${_IMPORT_PREFIX}/lib/libsndfile.a" )

# Import target "SndFile::sndfile-info" for configuration "Debug"
set_property(TARGET SndFile::sndfile-info APPEND PROPERTY IMPORTED_CONFIGURATIONS DEBUG)
set_target_properties(SndFile::sndfile-info PROPERTIES
  IMPORTED_LOCATION_DEBUG "${_IMPORT_PREFIX}/bin/sndfile-info"
  )

list(APPEND _IMPORT_CHECK_TARGETS SndFile::sndfile-info )
list(APPEND _IMPORT_CHECK_FILES_FOR_SndFile::sndfile-info "${_IMPORT_PREFIX}/bin/sndfile-info" )

# Import target "SndFile::sndfile-play" for configuration "Debug"
set_property(TARGET SndFile::sndfile-play APPEND PROPERTY IMPORTED_CONFIGURATIONS DEBUG)
set_target_properties(SndFile::sndfile-play PROPERTIES
  IMPORTED_LOCATION_DEBUG "${_IMPORT_PREFIX}/bin/sndfile-play"
  )

list(APPEND _IMPORT_CHECK_TARGETS SndFile::sndfile-play )
list(APPEND _IMPORT_CHECK_FILES_FOR_SndFile::sndfile-play "${_IMPORT_PREFIX}/bin/sndfile-play" )

# Import target "SndFile::sndfile-convert" for configuration "Debug"
set_property(TARGET SndFile::sndfile-convert APPEND PROPERTY IMPORTED_CONFIGURATIONS DEBUG)
set_target_properties(SndFile::sndfile-convert PROPERTIES
  IMPORTED_LOCATION_DEBUG "${_IMPORT_PREFIX}/bin/sndfile-convert"
  )

list(APPEND _IMPORT_CHECK_TARGETS SndFile::sndfile-convert )
list(APPEND _IMPORT_CHECK_FILES_FOR_SndFile::sndfile-convert "${_IMPORT_PREFIX}/bin/sndfile-convert" )

# Import target "SndFile::sndfile-cmp" for configuration "Debug"
set_property(TARGET SndFile::sndfile-cmp APPEND PROPERTY IMPORTED_CONFIGURATIONS DEBUG)
set_target_properties(SndFile::sndfile-cmp PROPERTIES
  IMPORTED_LOCATION_DEBUG "${_IMPORT_PREFIX}/bin/sndfile-cmp"
  )

list(APPEND _IMPORT_CHECK_TARGETS SndFile::sndfile-cmp )
list(APPEND _IMPORT_CHECK_FILES_FOR_SndFile::sndfile-cmp "${_IMPORT_PREFIX}/bin/sndfile-cmp" )

# Import target "SndFile::sndfile-metadata-set" for configuration "Debug"
set_property(TARGET SndFile::sndfile-metadata-set APPEND PROPERTY IMPORTED_CONFIGURATIONS DEBUG)
set_target_properties(SndFile::sndfile-metadata-set PROPERTIES
  IMPORTED_LOCATION_DEBUG "${_IMPORT_PREFIX}/bin/sndfile-metadata-set"
  )

list(APPEND _IMPORT_CHECK_TARGETS SndFile::sndfile-metadata-set )
list(APPEND _IMPORT_CHECK_FILES_FOR_SndFile::sndfile-metadata-set "${_IMPORT_PREFIX}/bin/sndfile-metadata-set" )

# Import target "SndFile::sndfile-metadata-get" for configuration "Debug"
set_property(TARGET SndFile::sndfile-metadata-get APPEND PROPERTY IMPORTED_CONFIGURATIONS DEBUG)
set_target_properties(SndFile::sndfile-metadata-get PROPERTIES
  IMPORTED_LOCATION_DEBUG "${_IMPORT_PREFIX}/bin/sndfile-metadata-get"
  )

list(APPEND _IMPORT_CHECK_TARGETS SndFile::sndfile-metadata-get )
list(APPEND _IMPORT_CHECK_FILES_FOR_SndFile::sndfile-metadata-get "${_IMPORT_PREFIX}/bin/sndfile-metadata-get" )

# Import target "SndFile::sndfile-interleave" for configuration "Debug"
set_property(TARGET SndFile::sndfile-interleave APPEND PROPERTY IMPORTED_CONFIGURATIONS DEBUG)
set_target_properties(SndFile::sndfile-interleave PROPERTIES
  IMPORTED_LOCATION_DEBUG "${_IMPORT_PREFIX}/bin/sndfile-interleave"
  )

list(APPEND _IMPORT_CHECK_TARGETS SndFile::sndfile-interleave )
list(APPEND _IMPORT_CHECK_FILES_FOR_SndFile::sndfile-interleave "${_IMPORT_PREFIX}/bin/sndfile-interleave" )

# Import target "SndFile::sndfile-deinterleave" for configuration "Debug"
set_property(TARGET SndFile::sndfile-deinterleave APPEND PROPERTY IMPORTED_CONFIGURATIONS DEBUG)
set_target_properties(SndFile::sndfile-deinterleave PROPERTIES
  IMPORTED_LOCATION_DEBUG "${_IMPORT_PREFIX}/bin/sndfile-deinterleave"
  )

list(APPEND _IMPORT_CHECK_TARGETS SndFile::sndfile-deinterleave )
list(APPEND _IMPORT_CHECK_FILES_FOR_SndFile::sndfile-deinterleave "${_IMPORT_PREFIX}/bin/sndfile-deinterleave" )

# Import target "SndFile::sndfile-concat" for configuration "Debug"
set_property(TARGET SndFile::sndfile-concat APPEND PROPERTY IMPORTED_CONFIGURATIONS DEBUG)
set_target_properties(SndFile::sndfile-concat PROPERTIES
  IMPORTED_LOCATION_DEBUG "${_IMPORT_PREFIX}/bin/sndfile-concat"
  )

list(APPEND _IMPORT_CHECK_TARGETS SndFile::sndfile-concat )
list(APPEND _IMPORT_CHECK_FILES_FOR_SndFile::sndfile-concat "${_IMPORT_PREFIX}/bin/sndfile-concat" )

# Import target "SndFile::sndfile-salvage" for configuration "Debug"
set_property(TARGET SndFile::sndfile-salvage APPEND PROPERTY IMPORTED_CONFIGURATIONS DEBUG)
set_target_properties(SndFile::sndfile-salvage PROPERTIES
  IMPORTED_LOCATION_DEBUG "${_IMPORT_PREFIX}/bin/sndfile-salvage"
  )

list(APPEND _IMPORT_CHECK_TARGETS SndFile::sndfile-salvage )
list(APPEND _IMPORT_CHECK_FILES_FOR_SndFile::sndfile-salvage "${_IMPORT_PREFIX}/bin/sndfile-salvage" )

# Commands beyond this point should not need to know the version.
set(CMAKE_IMPORT_FILE_VERSION)
