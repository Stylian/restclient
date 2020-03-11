#!/bin/sh

my_dir="$(dirname "$0")"

source $my_dir/config.ini

method="$1"
url="$2"
shift
shift
body="$@"

echo method: $method
echo url: $url
echo body: $body
echo -----------------
"$java_path" --enable-preview -jar $my_dir/console.jar "$method" "$url" "$body"
