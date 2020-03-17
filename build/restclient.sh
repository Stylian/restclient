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

var=($(grep -F __param__ $my_dir/config.ini | grep -Fv "#"))
added_params="$(IFS=; printf '%s' "${var[*]/__param__/&}")"
echo additional parameters: $added_params

echo body: $body
echo ----------------------------------

if [[ $url == *"?"* ]]; then
  url=${url}${added_params}
else
  url=${url}?r=1${added_params}
fi

echo final_url: $url

"$java_path" --enable-preview -jar $my_dir/console.jar "$method" "$url" "$body"
