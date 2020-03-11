#!/bin/sh

my_dir="$(dirname "$0")"

source $my_dir/config.ini

"$java_path" --enable-preview -jar $my_dir/console.jar $1 $2
